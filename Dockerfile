# Use the official OpenJDK 17 as the base image
FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY pom.xml .
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw package

# Use AdoptOpenJDK 17 as the base image
FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
