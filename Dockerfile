# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11

# Refer to Maven build -> finalName
ARG JAR_FILE=target/keygen-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

COPY src/main/resources .

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} key_gen.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","key_gen.jar"]