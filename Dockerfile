# ---------- Stage 1: Build Stage ----------
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies for better caching
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the application (skip tests to speed up build)
RUN mvn clean package -DskipTests

# ---------- Stage 2: Slim Runtime ----------
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy only the compiled JAR from the builder stage
COPY --from=builder /app/target/HotelService-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 4020

# Run the application with the "docker" Spring profile
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]
