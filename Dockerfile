# -------- Stage 1: Build --------
FROM gradle:8.5-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# -------- Stage 2: Run --------
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
