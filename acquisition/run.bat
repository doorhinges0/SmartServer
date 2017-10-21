@echo on
set JAVA_HOME=.\jdk1.6.0_22
set PATH=%JAVA_HOME%/bin;%JAVA_HOME%/jre/bin
set CLASSPATH=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;
::::::::::::::::::::::::::::::::::::::::::::::::Other lib::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
set CLASSPATH=%CLASSPATH%;.\lib\commons-collections-3.2.jar;
set CLASSPATH=%CLASSPATH%;.\lib\commons-io-2.1.jar;
set CLASSPATH=%CLASSPATH%;.\lib\commons-lang-2.3.jar;
set CLASSPATH=%CLASSPATH%;.\lib\commons-logging.jar;
set CLASSPATH=%CLASSPATH%;.\lib\filterbuilder.jar;
set CLASSPATH=%CLASSPATH%;.\lib\htmllexer.jar;
set CLASSPATH=%CLASSPATH%;.\lib\htmlparser.jar;
set CLASSPATH=%CLASSPATH%;.\lib\sitecapturer.jar;
set CLASSPATH=%CLASSPATH%;.\lib\thumbelina.jar;
set CLASSPATH=%CLASSPATH%;.\lib\acquisition.jar;
echo %CLASSPATH%
java -version 
java acquisition.run.Run
 
pause