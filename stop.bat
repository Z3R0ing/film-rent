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
echo ...Stopping...
call gradlew.bat stop
pause