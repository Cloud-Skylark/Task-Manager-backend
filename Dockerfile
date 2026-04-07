# Build Stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run Stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Database connection details (Environment Variables)

ENV DB_URL=jdbc:postgresql://postgres-service:5432/taskdb
ENV DB_USER=postgres
ENV DB_PASS=password

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]