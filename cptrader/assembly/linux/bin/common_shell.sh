#!/bin/bash

function check_server_started(){
    CONF_DIR=$1
    SERVER_NAME=$2
    PIDS=$(ps -ef | grep java | grep "$CONF_DIR" |grep -v grep |awk '{print $2}')
    if [ -n "$PIDS" ]; then
        echo "ERROR: The $SERVER_NAME already started!"
        echo "PID: $PIDS"
        exit 1
    fi
}

function check_server_stopped(){
    CONF_DIR=$1
    SERVER_NAME=$2
    PIDS=$(ps -ef | grep java | grep "$CONF_DIR" | grep -v grep | awk '{print $2}')
    if [ -z "$PIDS" ]; then
        echo "ERROR: The $SERVER_NAME does not started!"
        exit 1
    fi
}

function check_server_port(){
    SERVER_PORT=$1
    if [ -n "$SERVER_PORT" ]; then
        SERVER_PORT_COUNT=$(netstat -tln | grep $SERVER_PORT |grep -v grep | wc -l)
        if [ $SERVER_PORT_COUNT -gt 0 ]; then
            echo "ERROR: The $SERVER_NAME port $SERVER_PORT already used!"
            exit 1
        fi
    fi
}

# check logs dir
function check_stdout_file(){
    typeset LOGS_DIR
    LOGS_FILE=$1
    DEPLOY_DIR=$2
    if [ -n "$LOGS_FILE" ]; then
        LOGS_DIR=$(dirname $LOGS_FILE)
    else
        LOGS_DIR=$DEPLOY_DIR/logs
    fi
    if [ ! -d $LOGS_DIR ]; then
        mkdir $LOGS_DIR
    fi
    STDOUT_FILE=$LOGS_DIR/stdout.log
}

function start_server(){

    DEPLOY_DIR=$1
    JAVA_MEM_OPTS=$2
    OOM_DUMP_DIR=$3
    CONF_DIR=$4
    DEBUG=$5

    # set lib
    #LIB_DIR=$DEPLOY_DIR/lib
    LIB_DIR=$DEPLOY_DIR/bin


    LIB_JARS=$(ls $LIB_DIR | grep .jar | grep -v grep | awk '{print "'$LIB_DIR'/"$0}' | tr "\n" ":")


    #set java options
    JAVA_OPTS="-Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$OOM_DUMP_DIR"
    JAVA_DEBUG_OPTS=""
    if [ "$DEBUG" = "debug" ]; then
        JAVA_DEBUG_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
    fi
    JAVA_JMX_OPTS=""
    if [ "$DEBUG" = "jmx" ]; then
        JAVA_JMX_OPTS="-Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
    fi
    BITS=$(java -version 2>&1 | grep -i 64-bit | grep -v grep)

    #start server
    #cd $DEPLOY_DIR
    echo -e "Starting the $SERVER_NAME $LIB_JARS ...\c"
    echo "######PATH=" > $DEPLOY_DIR/logs/std.log
    echo $PATH >> $DEPLOY_DIR/logs/std.log

    echo "######ID=" >> $DEPLOY_DIR/logs/std.log
    /usr/bin/id >> $DEPLOY_DIR/logs/std.log
    nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS -classpath $CONF_DIR:$LIB_JARS $MAIN_CLASS >> $DEPLOY_DIR/logs/std.log 2>&1 &
    #cd $BIN_DIR
}


# check if server started
function check_is_started(){
    typeset -i COUNT=0
    typeset -i time_out_count=0
    DEPLOY_DIR=$1
    while [ $COUNT -lt 1 ]; do
        if [ $time_out_count -gt 30 ]; then
            echo -e "\n start time out\n"
            exit 1
        fi

        echo -e ".\c"
        sleep 1

        COUNT=$(ps -ef | grep java | grep "$DEPLOY_DIR" | grep -v grep | awk '{print $2}' | wc -l)

        if [ $COUNT -gt 0 ]; then
            break
        fi
        ((time_out_count++))
    done

    echo "OK!"
    PIDS=$(ps -ef | grep java | grep "$DEPLOY_DIR" | grep -v grep | awk '{print $2}')
    echo "PID: $PIDS"
}

# kill
function kill_pids(){
    SERVER_NAME=$1
    echo -e "Stopping the $SERVER_NAME ...\c"
    for PID in $PIDS ; do
        kill $PID > /dev/null 2>&1
    done
}

#force kill
function force_kill_pids()
{
    echo "force kill "
    for PID in $PIDS ;do
        kill -9 $PID > /dev/null 2>&1
    done
}

# check if stop
function check_is_stopped(){
    STOP_TIMEOUT=$1
    PIDS=$2
    typeset -i COUNT=0
    while [ $COUNT -lt $STOP_TIMEOUT ]; do
        echo -e ".\c"
        sleep 1
        #COUNT=1
        COUNT=$((COUNT + 1))
        for PID in $PIDS ; do
            PID_EXIST=$(ps -ef | grep $PID |grep -v grep)
            if [ "" == "$PID_EXIST" ]; then
                COUNT=$((STOP_TIMEOUT + 1))
                break
            fi
        done

        if [ $COUNT -eq $STOP_TIMEOUT ];then
            force_kill_pids
        fi
    done

    echo "OK!"
    echo "PID: $PIDS"
}

# check logs dir


function check_log_dir(){
    LOGS_FILE=$1
    DEPLOY_DIR=$2
    if [ -n "$LOGS_FILE" ]; then
        LOGS_DIR=$(dirname $LOGS_FILE)
    else
        LOGS_DIR=$DEPLOY_DIR/logs
    fi
    if [ ! -d $LOGS_DIR ]; then
        mkdir $LOGS_DIR
    fi
}

#check dump dir
function check_dump_dir(){
    LOGS_DIR=$1
    DUMP_DIR=$LOGS_DIR/dump
    if [ ! -d $DUMP_DIR ]; then
        mkdir $DUMP_DIR
    fi
    typeset DUMP_DATE=$(date +%Y%m%d%H%M%S)
    DATE_DIR=$DUMP_DIR/$DUMP_DATE
    if [ ! -d $DATE_DIR ]; then
        mkdir $DATE_DIR
    fi
}

# dump
function dump_file(){
    SERVER_NAME=$1
    PIDS=$2
    DATE_DIR=$3
    echo -e "Dumping the $SERVER_NAME ...\c"
    for PID in $PIDS ; do
        jstack $PID > $DATE_DIR/jstack-$PID.dump 2>&1
        echo -e ".\c"
        jinfo $PID > $DATE_DIR/jinfo-$PID.dump 2>&1
        echo -e ".\c"
        jstat -gcutil $PID > $DATE_DIR/jstat-gcutil-$PID.dump 2>&1
        echo -e ".\c"
        jstat -gccapacity $PID > $DATE_DIR/jstat-gccapacity-$PID.dump 2>&1
        echo -e ".\c"
        jmap $PID > $DATE_DIR/jmap-$PID.dump 2>&1
        echo -e ".\c"
        jmap -heap $PID > $DATE_DIR/jmap-heap-$PID.dump 2>&1
        echo -e ".\c"
        jmap -histo $PID > $DATE_DIR/jmap-histo-$PID.dump 2>&1
        echo -e ".\c"
        if [ -r /usr/sbin/lsof ]; then
        /usr/sbin/lsof -p $PID > $DATE_DIR/lsof-$PID.dump
        echo -e ".\c"
        fi
    done

    if [ -r /bin/netstat ]; then
        /bin/netstat -an > $DATE_DIR/netstat.dump 2>&1
        echo -e ".\c"
    fi
    if [ -r /usr/bin/iostat ]; then
        /usr/bin/iostat > $DATE_DIR/iostat.dump 2>&1
        echo -e ".\c"
    fi
    if [ -r /usr/bin/mpstat ]; then
        /usr/bin/mpstat > $DATE_DIR/mpstat.dump 2>&1
        echo -e ".\c"
    fi
    if [ -r /usr/bin/vmstat ]; then
        /usr/bin/vmstat > $DATE_DIR/vmstat.dump 2>&1
        echo -e ".\c"
    fi
    if [ -r /usr/bin/free ]; then
        /usr/bin/free -t > $DATE_DIR/free.dump 2>&1
        echo -e ".\c"
    fi
    if [ -r /usr/bin/sar ]; then
        /usr/bin/sar > $DATE_DIR/sar.dump 2>&1
        echo -e ".\c"
    fi
    if [ -r /usr/bin/uptime ]; then
        /usr/bin/uptime > $DATE_DIR/uptime.dump 2>&1
        echo -e ".\c"
    fi

    echo "OK!"
    echo "DUMP: $DATE_DIR"
}

function make_dump_dir(){
    OOM_DUMP_DIR=$1
    if [ ! -d "$OOM_DUMP_DIR" ]; then
        mkdir -p $OOM_DUMP_DIR
    fi
}

function startup(){
    check_server_started "$CONF_DIR" "$SERVER_NAME"

    make_dump_dir "$OOM_DUMP_DIR"
    start_server "$DEPLOY_DIR" "$JAVA_MEM_OPTS" "$OOM_DUMP_DIR"  "$CONF_DIR"  $1
    check_is_started "$DEPLOY_DIR"
}

function shutdown(){

    typeset PIDS
    check_server_stopped "$CONF_DIR" "$SERVER_NAME"
    kill_pids "$SERVER_NAME"
}

function dump(){
    DUMP_SERVER=$SERVER_NAME
    typeset DUMP_DIR DATE_DIR STDOUT_FILE
    typeset PIDS
    check_server_stopped
    check_log_dir "$LOGS_FILE" "$DEPLOY_DIR"
    check_dump_dir "$LOGS_FILE"
    dump_file "$DUMP_SERVER" "$PIDS" "$DATE_DIR"
}
