@echo off
setlocal enableextensions
pushd %~dp0

cd ..\..\
call gradlew clean shadowJar

cd build\libs
for /f "tokens=*" %%a in (
    'dir /b *.jar'
) do (
    set jarloc=%%a
)

java -jar %jarloc% < ..\..\text-ui-test\add_test\input.txt > ..\..\text-ui-test\add_test\ACTUAL.TXT

ECHO Add Test:

FC ..\..\text-ui-test\add_test\ACTUAL.TXT ..\..\text-ui-test\add_test\EXPECTED.TXT && ECHO Test passed! || Echo Test failed!

cd ..\..\text-ui-test