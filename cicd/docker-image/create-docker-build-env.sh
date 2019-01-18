#!/usr/bin/env bash

echo $(pwd)
find ./artifacts
find ./workspace

cp -a artifacts workspace
cp -a resource-inschrijving-product/cicd/docker-image/Dockerfile workspace

ls -l
find ./workspace

echo "created docker build environment!"