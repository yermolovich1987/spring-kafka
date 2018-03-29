To run Kafka manually via OOTB configuration:
1) Start the Zookeeper server by executing the command:
    bin/zookeeper-server-start.sh config/zookeeper.properties
2) Start the Kafka server by executing:
    bin/kafka-server-start.sh config/server.properties
3) Create a test topic that you can use for testing:
    bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic javaworld
4) Start a simple console consumer that can consume messages published to a given topic, such as javaworld:
    bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic javaworld --from-beginning.
5) Start up a simple producer console that can publish messages to the test topic:
    bin/kafka-console-producer.sh --broker-list localhost:9092 --topic javaworld