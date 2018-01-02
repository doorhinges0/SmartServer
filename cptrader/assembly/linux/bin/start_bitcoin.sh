#!/bin/bash

java -jar  bitcoin.trader-2.1-SNAPSHOT.jar
set JAVA_OPTIONS=-Djava.ext.dirs=../lib:.:%JAVA_HOME%/jre/lib/ext
