#!/usr/bin/env bash

# change to script directory
cd "${0%/*}"

cd ../../
./gradlew clean shadowJar

cd text-ui-test

java  -jar $(find ../build/libs/ -mindepth 1 -print -quit) < delete_test/input.txt > delete_test/ACTUAL.TXT

cp delete_test/EXPECTED.TXT delete_test/EXPECTED-UNIX.TXT
dos2unix text-ui-test/delete_test/EXPECTED-UNIX.TXT delete_test/ACTUAL.TXT
diff delete_test/EXPECTED-UNIX.TXT delete_test/ACTUAL.TXT
if [ $? -eq 0 ]
then
    echo "Test passed!"
    exit 0
else
    echo "Test failed!"
    exit 1
fi
