#!/usr/bin/env bash

# change to script directory
cd "${0%/*}"

cd ../../
./gradlew clean shadowJar

cd text-ui-test

java  -jar $(find ../build/libs/ -mindepth 1 -print -quit) < general_test/input.txt > general_test/ACTUAL.TXT

cp ../../text-ui-test/general_test/EXPECTED.TXT ../../text-ui-test/general_test/EXPECTED-UNIX.TXT
dos2unix ../../text-ui-test/general_test/EXPECTED-UNIX.TXT ../../text-ui-test/general_test/ACTUAL.TXT
diff ../../text-ui-test/general_test/EXPECTED-UNIX.TXT ../../text-ui-test/general_test/ACTUAL.TXT
if [ $? -eq 0 ]
then
    echo "Test passed!"
    exit 0
else
    echo "Test failed!"
    exit 1
fi
