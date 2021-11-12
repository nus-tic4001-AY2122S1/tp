@ECHO OFF

REM Navigate to existing tests and call them
cd general_test
call runtest.bat
cd ..

cd add_test
call runtest.bat
cd ..

cd edit_test
call runtest.bat
cd ..

cd delete_test
call runtest.bat
cd ..

pause


