FROM openjdk:17-jdk-slim
COPY target/*.jar job-assistant.jar
ENTRYPOINT ["java","-jar","job-assistant.jar"]