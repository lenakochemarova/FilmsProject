@echo off
mvn clean package

start "" javaw -jar target/FilmsProject-1.0-SNAPSHOT.jar
start "" "http://localhost:8080"