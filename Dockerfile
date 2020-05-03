FROM maven:latest as builder
COPY pom.xml /tmp/
COPY src /tmp/src
WORKDIR /tmp/
RUN mvn package

FROM openjdk:12-alpine
COPY --from=builder /tmp/target/spring-scala*dependencies.jar /usr/app/app.jar
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "app.jar"]