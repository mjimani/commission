#!/bin/sh

imageName='commission'
echo $imageName

# shellcheck disable=SC2046
sudo docker rm $(docker stop $(docker ps -a -q --filter ancestor=$imageName --format="{{.ID}}"))

sudo docker rmi -f $imageName

sudo docker build -t $imageName .

rm -rf docker-compose.yml

echo "version: '3'"							>> docker-compose.yml
echo "services:"							>> docker-compose.yml
echo "    "$imageName":"						>> docker-compose.yml
echo "        container_name: '"$imageName"'"				>> docker-compose.yml
echo "        image: "$imageName					>> docker-compose.yml
echo "        networks:"						>> docker-compose.yml
echo "            - mjimani-net"					>> docker-compose.yml
echo "        ports:"						>> docker-compose.yml
echo "            - '8080:8080'"				>> docker-compose.yml
echo "networks:"						>> docker-compose.yml
echo "    mjimani-net:"						>> docker-compose.yml
echo "        external:"					>> docker-compose.yml
echo "            name: mjimani-net"				>> docker-compose.yml

sudo docker-compose up
