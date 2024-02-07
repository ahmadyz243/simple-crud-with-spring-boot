# Use the official maven/Java 17 image to create a build artifact
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package

# Use AdoptOpenJDK 17 as the base image
FROM adoptopenjdk:17-jre-hotspot
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]