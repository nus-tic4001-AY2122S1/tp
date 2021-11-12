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

java -jar %jarloc% < ..\..\text-ui-test\edit_test\input.txt > ..\..\text-ui-test\edit_test\ACTUAL.TXT

ECHO Edit Test:

FC ..\..\text-ui-test\edit_test\ACTUAL.TXT ..\..\text-ui-test\edit_test\EXPECTED.TXT >NUL && ECHO Test passed! || Echo Test failed!

cd ..\..\text-ui-test