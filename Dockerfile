FROM openjdk:11-jre-slim

ARG JAR_FILE=build/libs/scaffold-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /scaffold.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/scaffold.jar"]
