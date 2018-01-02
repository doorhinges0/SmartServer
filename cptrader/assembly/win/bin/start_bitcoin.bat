@ECHO OFF
set CLASSPATH=%JAVA_HOME%/lib
set JAVA=%JAVA_HOME%/bin/java

set CLASSPATH=%CLASSPATH%;../conf
set JAVA_OPTIONS=-Djava.ext.dirs=../lib;.;%JAVA_HOME%/jre/lib/ext

echo %JAVA_OPTIONS%

java  -Xms512m -Xmx1024m -classpath "%CLASSPATH%" %JAVA_OPTIONS% com.rfc.main.CoinTrader


pause


