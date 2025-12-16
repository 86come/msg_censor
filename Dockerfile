# syntax=docker/dockerfile:1

FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace

# Cache dependencies first
COPY pom.xml .
RUN mvn -q -B -DskipTests dependency:go-offline

# Copy sources and build
COPY src src
RUN mvn -q -B -DskipTests package

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Create non-root user
RUN addgroup -S spring && adduser -S spring -G spring

# Copy the fat jar
COPY --from=build /workspace/target/*.jar /app/app.jar

ENV JAVA_OPTS=""
EXPOSE 8080
USER spring:spring
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]

