#!/bin/bash

echo "------------------------------------"
echo " Starting Spring Boot Microservices "
echo "------------------------------------"

LOG_DIR="logs"

# Create logs folder if not exists
mkdir -p $LOG_DIR

start_service() {
    NAME=$1
    DIR=$2

    JAR_FILE=$(ls $DIR/target/*.jar 2>/dev/null | head -n 1)

    if [[ -z "$JAR_FILE" ]]; then
        echo "❌ JAR not found for $NAME in $DIR/target/"
    else
        echo "Starting $NAME..."
        nohup java -jar "$JAR_FILE" > "$LOG_DIR/$NAME.log" 2>&1 &
    fi
}

# Start Eureka first
start_service "eureka_server" "eureka_server"
sleep 5

# Start Config Server
start_service "configservice" "configservice"
sleep 3

# Start others
start_service "authservice" "authservice"
start_service "userservice" "userservice"
start_service "postservice" "postservice"
start_service "commentservice" "commentservice"

# Start API Gateway last
start_service "api_gateway" "api_gateway"

echo "------------------------------------"
echo " All microservices are starting..."
echo " Logs created in folder: logs/"
echo "------------------------------------"
