# Use a lightweight JDK image
FROM eclipse-temurin:21-jdk-alpine

# Create app directory
WORKDIR /app

# Copy the built JAR into the container
COPY build/libs/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
