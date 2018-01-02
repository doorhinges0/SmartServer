#!/bin/bash
typeset BIN_DIR DEPLOY_DIR CONF_DIR
typeset SERVER_NAME SERVER_PROTOCOL SERVER_PORT LOGS_FILE

export BIN_DIR=$(pwd)
export DEPLOY_DIR=$(dirname $BIN_DIR)
export CONF_DIR=$DEPLOY_DIR/conf

typeset APP_CONF_FILE=$CONF_DIR/app.properties
MAIN_CLASS=`sed '/application.main/!d;s/.*=//' $APP_CONF_FILE | tr -d '\r'`
SERVER_NAME=`sed '/application.name/!d;s/.*=//' $APP_CONF_FILE| tr -d '\r'`
if [ -z "$SERVER_NAME" ]; then
    SERVER_NAME=$(hostname)
fi
export SERVER_NAME
#oom dump config
export OOM_DUMP_DIR=$DEPLOY_DIR/logs/dump


# timeout config , if application stop timeout force kill process
export STOP_TIMEOUT=10
# jvm memory config
export JAVA_MEM_OPTS="-server -Xms2048m -Xmx4096m -XX:SurvivorRatio=2 -XX:+UseParallelGC"
