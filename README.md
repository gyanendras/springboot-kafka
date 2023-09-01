# springboot-kafka
Run this docker kafka image to test sending and recieving of messages
version: "3"
services:
 kafka:
    image: 'bitnami/kafka:latest'
    ports:
      - '29092:29092'
    environment:
      - KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE=true
      - BITNAMI_DEBUG=true
      - KAFKA_CFG_NODE_ID=0
      - KAFKA_CFG_PROCESS_ROLES=controller,broker
      - KAFKA_CFG_LISTENERS=CONTROLLER://:9093,EXTERNAL_SAME_HOST://:29092,INTERNAL://:9092
      - KAFKA_ADVERTISED_LISTENERS=INTERNAL://kafka:9092,EXTERNAL_SAME_HOST://localhost:29092
      - KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,EXTERNAL_SAME_HOST:PLAINTEXT,INTERNAL:PLAINTEXT
      - KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@kafka:9093
      - KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER
      - KAFKA_INTER_BROKER_LISTENER_NAME=INTERNAL
