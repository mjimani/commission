#!/bin/sh

imageName='commission'

# Remove target directory and old deploy
rm -rf target
rm -rf _deploy/app.jar
rm -rf _deploy/docker-compose.yml
# build
mvn clean package

# copy jar file
cp target/*.jar _deploy/app.jar

cd _deploy
./dockerBuild.sh
