#!/usr/bin/env bash

PWD=$(pwd)
echo "PWD: ${PWD}"

M2_LOCAL=${PWD}/m2/rootfs/m2
echo "M2_LOCAL: ${M2_LOCAL}"

MVN_SETTINGS=${M2_LOCAL}/settings.xml
echo "MVN_SETTINGS: ${MVN_SETTINGS}"

cat > ${MVN_SETTINGS} << EOF

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
      <localRepository>${M2_LOCAL}/repository</localRepository>
</settings>

EOF

cd ${PWD}/resource-inschrijving-product
cat ${MVN_SETTINGS}
mvn -s ${MVN_SETTINGS} -DskipTests clean package
cp -a target/* ../artifacts/
