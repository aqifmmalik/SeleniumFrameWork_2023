set mypath=%cd%
set bin=%mypath%\bin
set jar=%mypath%\IO\Jars
echo %mypath%  
cd\
cd %mypath%
set classpath=%bin%;%jar%\*;
 
java org.testng.TestNG testng.xml
