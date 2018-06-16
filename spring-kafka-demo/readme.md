To run this demo you will need to execute next setup steps for Kafka:
1) Start the Zookeeper server by executing the command:
    bin/zookeeper-server-start.sh config/zookeeper.properties
2) Start the Kafka servers by executing (Corresponding configurations should be defined with different ids and listener ports):
    bin/kafka-server-start.sh config/server.properties

    bin/kafka-server-start.sh config/server.1.properties
    bin/kafka-server-start.sh config/server.2.properties
    bin/kafka-server-start.sh config/server.3.properties
3) Create a test topic that you can use for testing:
    bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 3 --topic partitioned

    bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic simple


--------

To send a test messages to particular topic the next test endpoint could be used:
http://localhost:8080/send?topic=firstTopic&message=%22Hello%20world%22