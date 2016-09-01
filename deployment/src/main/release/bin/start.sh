#!/bin/bash
export JAVA_HOME=/opt/openo/rtsp/jre
export CATALINA_BASE=/opt/openo/apps/DriverManagerService
export TOMCAT_LOG=../logs
export CATALINA_HOME=/opt/openo/rtsp/apache-tomcat-7.0.68

if [ -z "$JAVA_HOME" ]
then
    echo "There is no JAVA_HOME"
    exit 1
fi

if [ -z "$CATALINA_HOME" ]
then
    echo "There is no CATALINA_HOME"
    exit 1
fi

if [ -z "$CATALINA_BASE" ]
then
    echo "There is no CATALINA_BASE"
    exit 1
fi

LOG_DIR=$CATALINA_BASE/logs
if [ ! -d "$LOG_DIR" ]; then
  mkdir $LOG_DIR
fi

ACCESS_GRP=$OPENO_HOME/groups
if [ ! -d "$ACCESS_GRP" ];
then
    mkdir $ACCESS_GRP
fi


$CATALINA_HOME/bin/catalina.sh start

