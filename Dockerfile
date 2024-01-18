FROM openjdk:17
EXPOSE 8080
ADD target/api-0.0.1.jar api-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/api-0.0.1.jar"]
