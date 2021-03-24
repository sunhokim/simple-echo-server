#!/bin/bash

mvn clean package

docker build -t simple-echo-http:latest .

docker run -d -p 8080:8080 --restart=always --name=echo-server-http simple-echo-http:latest