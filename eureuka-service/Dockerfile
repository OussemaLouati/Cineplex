FROM java:8
VOLUME /tmp
EXPOSE 8761
ADD target/eureuka-service-0.0.1-SNAPSHOT.jar eureuka-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","eureuka-service-0.0.1-SNAPSHOT.jar"]
