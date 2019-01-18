#!/usr/bin/env bash

cp -a artifacts/* workspace
cp -a resource-inschrijving-product/cicd/docker-image/Dockerfile workspace

echo "created docker build environment!"