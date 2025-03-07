FROM openjdk:17-jdk-alpine
COPY target/finanzas-0.0.1-SNAPSHOT.jar spring-back-app.jar
ENTRYPOINT ["java", "-jar", "spring-back-app.jar"]
