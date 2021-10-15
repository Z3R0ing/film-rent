@echo off
echo.
echo.
echo 2021.10.15 filmrent-build.bat
REM by Z3R0ing
echo.
echo ########  #######  ########    #####   #### ##    ##  ######
echo      ##  ##     ## ##     ##  ##   ##   ##  ###   ## ##    ##
echo     ##          ## ##     ## ##     ##  ##  ####  ## ##
echo    ##     #######  ########  ##     ##  ##  ## ## ## ##   ####
echo   ##            ## ##   ##   ##     ##  ##  ##  #### ##    ##
echo  ##      ##     ## ##    ##   ##   ##   ##  ##   ### ##    ##
echo ########  #######  ##     ##   #####   #### ##    ##  ######
echo.
echo.
echo Please, press Ctrl+C if you see errors or red lines
echo.
echo ...Start building...
call gradlew.bat build
echo.
echo ...Creating database...
call gradlew.bat createDb
echo.
echo ...Updating database...
call gradlew.bat updateDb
echo.
echo ...Setuping tomcat...
call gradlew.bat setupTomcat
echo.
echo ...Setting env...
more env.txt > deploy\tomcat\bin\setenv.bat
echo.
echo thanks for work!
pause