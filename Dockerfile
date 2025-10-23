FROM amazoncorretto:17-alpine-jdk
COPY target/*.jar job-assistant.jar
ENTRYPOINT ["java","-jar","/job-assistant.jar"]