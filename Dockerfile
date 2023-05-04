FROM openjdk:17.0.1-jdk
ARG JAR_FILE=build/libs/ms-check-collector.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]