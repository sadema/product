#!/usr/bin/env bash

PWD=$(pwd)
echo "PWD: ${PWD}"

M2_LOCAL_REPO=${PWD}/m2/rootfs/m2
echo "M2_LOCAL_REPO: ${M2_LOCAL_REPO}"

MVN_SETTINGS=${M2_LOCAL_REPO}/settings.xml
echo "MVN_SETTINGS: ${MVN_SETTINGS}"

cd ${PWD}/resource-inschrijving-product
cat ${MVN_SETTINGS}
mvn -s ${MVN_SETTINGS} clean package
cp -a target/* ../artifacts/
