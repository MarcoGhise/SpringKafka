#Export JAVA
SET JAVA_HOME=C:\PROGRA~1\Java\jdk1.7.0_67

#Starting the ZooKeeper server
bin\windows\zookeeper-server-start.bat config/zookeeper.properties

#Starting the Kafka broker
bin\windows\kafka-server-start.bat config/server.properties

#Creating a Kafka topic
bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafkatopic

#Starting producer
bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic kafkatopic

#Starting consumer
bin\windows\kafka-console-consumer.bat --zookeeper localhost:2181 --topic kafkatopic --from-beginning

#Producer by Apache
https://cwiki.apache.org/confluence/display/KAFKA/0.8.0+Producer+Example

#Consumer by Apache
https://cwiki.apache.org/confluence/display/KAFKA/Consumer+Group+Example
