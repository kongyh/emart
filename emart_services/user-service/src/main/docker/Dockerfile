FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ../../target/user-service-0.0.1-SNAPSHOT.jar /user-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user-service.jar"
EXPOSE 9090
MAINTAINER kongyh
