IF %1.==. GOTO No1

:No1
  ECHO No param 1
GOTO End1

REM Move to directory
cd /apache-kafka-0.8.2.1

REM Export JAVA
SET JAVA_HOME=C:\PROGRA~1\Java\jdk1.7.0_67

REM Creating a Kafka topic
bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic %1

:End1
