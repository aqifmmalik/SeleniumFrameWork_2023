set mypath=%cd%
echo %mypath%  
cd %mypath%
cd IO\Reports\Html
RD /Q /S Screenshots

taskkill /IM geckodriver.exe /F
taskkill /IM IEDriver32.exe /F 
taskkill /IM IEDriver64.exe /F
taskkill /IM chromedriver.exe /F
taskkill /IM IEDriverServer.exe /F
taskkill /IM IEDriver32_old /F
taskkill /IM firefox.exe /F
taskkill /IM 1Chrome.exe /F

taskkill /IM excel.exe /F
taskkill /IM iexplore.exe /F


taskkill /IM conhost.exe /F
taskkill /IM postgres.exe /F
 
cd\
cd %mypath%
cd IO\TestCases
Excel.bat