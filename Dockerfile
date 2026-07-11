# Base Image
FROM eclipse-temurin:21-jdk

# Working Directory
WORKDIR /app

# Copy JAR file
COPY target/*.jar app.jar

# Application Port
EXPOSE 8080

# Run Spring Boot Application
ENTRYPOINT ["java", "-jar", "app.jar"]