#!/bin/sh
mvn clean package && docker build -t com.mycompany/JavaEEConcurrency .
docker rm -f JavaEEConcurrency || true && docker run -d -p 8080:8080 -p 4848:4848 --name JavaEEConcurrency com.mycompany/JavaEEConcurrency 
