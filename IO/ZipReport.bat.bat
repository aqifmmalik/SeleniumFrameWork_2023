set mypath=%cd%
echo %mypath%  
cd %mypath%
cd Reports


powershell Compress-Archive %mypath%\IO\Reports %mypath%\IO\Automation Report.zip

