#!/usr/bin/env bash

M2_LOCAL_REPO=m2/rootfs/m2
MVN_SETTINGS=${M2_LOCAL_REPO}/settings.xml
cd resource-inschrijving-product
cat ${MVN_SETTINGS}
#mvn -s ${MVN_SETTINGS} clean package
#cp -a target/* ../artifacts/
