@echo off
REM ########  #######  ########    #####   #### ##    ##  ######
REM      ##  ##     ## ##     ##  ##   ##   ##  ###   ## ##    ##
REM     ##          ## ##     ## ##     ##  ##  ####  ## ##
REM    ##     #######  ########  ##     ##  ##  ## ## ## ##   ####
REM   ##            ## ##   ##   ##     ##  ##  ##  #### ##    ##
REM  ##      ##     ## ##    ##   ##   ##   ##  ##   ### ##    ##
REM ########  #######  ##     ##   #####   #### ##    ##  ######
REM by Z3R0ing 2021.10.15
echo.
echo ...Setting env...
call env.bat > nul
echo.
echo ...Starting...
call gradlew.bat assemble deploy start
echo.
echo Now it available on http://localhost:8080/app/
echo.
echo It can be off by stop.bat
pause