# Use a lightweight OpenJDK base image
FROM eclipse-temurin:17-jdk-jammy

# Set work directory
WORKDIR /app

# Copy Maven build output (update if your JAR name differs)
COPY target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
