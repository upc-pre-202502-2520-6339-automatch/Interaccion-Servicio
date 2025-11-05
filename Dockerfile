# Etapa 1: Compilación
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/interactions-service-0.0.1-SNAPSHOT.jar app.jar

# Variables de entorno
ENV SPRING_PROFILES_ACTIVE=prod
ENV SERVER_PORT=8085

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]