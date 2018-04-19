@echo off

echo       -----------------------打包微服务-----------------------
echo.&echo.

call mvn clean
call mvn package -Dmaven.test.skip=true
echo;

echo 打包完成，开始复制文件...
copy /y target\*.jar C:\Users\ronglian\Desktop\deploy\
echo 文件复制完毕！
echo;

pause