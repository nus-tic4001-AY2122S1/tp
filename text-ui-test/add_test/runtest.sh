#!/usr/bin/env bash

# change to script directory
cd "${0%/*}"

cd ../../
./gradlew clean shadowJar

cd text-ui-test

java  -jar $(find ../build/libs/ -mindepth 1 -print -quit) < add_test/input.txt > add_test/ACTUAL.TXT

cp general_test/EXPECTED.TXT general_test/EXPECTED-UNIX.TXT
dos2unix text-ui-test/add_test/EXPECTED-UNIX.TXT add_test/ACTUAL.TXT
diff add_test/EXPECTED-UNIX.TXT add_test/ACTUAL.TXT
if [ $? -eq 0 ]
then
    echo "Test passed!"
    exit 0
else
    echo "Test failed!"
    exit 1
fi
