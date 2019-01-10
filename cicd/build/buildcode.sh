#!/usr/bin/env bash

cd resource-inschrijving-product
mvn clean package
cp -a target/* ../artifacts/
