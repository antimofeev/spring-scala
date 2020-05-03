FROM maven:latest as builder
COPY pom.xml /tmp/
COPY /akka-module/src /tmp/akka-module/src
COPY /akka-module/pom.xml /tmp/akka-module/pom.xml
COPY /core-module/src /tmp/core-module/src
COPY /core-module/pom.xml /tmp/core-module/pom.xml
COPY /main-module/src /tmp/main-module/src
COPY /main-module/pom.xml /tmp/main-module/pom.xml
COPY /spring-module/src /tmp/spring-module/src
COPY /spring-module/pom.xml /tmp/spring-module/pom.xml

WORKDIR /tmp/
RUN mvn package

FROM openjdk:12-alpine
COPY --from=builder /tmp/main-module/target/main*.jar /usr/app/app.jar
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "app.jar"]