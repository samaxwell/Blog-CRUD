#!/bin/sh

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! `nc -z configserver $CONFIGSERVER_PORT `; do sleep 3; done
echo ">>>>>>>>>>>> Configuration Server has started"

echo "********************************************************"
echo "Starting blog service "
echo "********************************************************"
java -Dspring.cloud.config.uri=$CONFIGSERVER_URI \
	 -Dspring.profiles.active=$PROFILE \
	 -jar /usr/local/app/BlogCrud-0.0.1.jar