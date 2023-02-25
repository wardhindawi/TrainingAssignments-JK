@echo off

cls

call set JAVA_HOME=D:\Developer\tools\jdk\jdk-17.0.5

call mvn clean package

@echo.
@echo.
@echo Run the following command:
@echo.
@echo %JAVA_HOME%\bin\java -jar target\java-sde1-training-0.0.1-SNAPSHOT-jar-with-dependencies.jar
@echo.
@echo.
call %JAVA_HOME%\bin\java -jar target\java-sde1-training-0.0.1-SNAPSHOT-jar-with-dependencies.jar