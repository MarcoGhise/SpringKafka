REM Move to directory
cd /apache-kafka-0.8.2.1

REM Export JAVA
SET JAVA_HOME=C:\PROGRA~1\Java\jdk1.7.0_67

REM Starting the Kafka broker
bin\windows\kafka-server-start.bat config/server.properties
