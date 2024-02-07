# Start your image with a node base image
FROM openjdk:20

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY target/practice-two-0.0.1-SNAPSHOT.jar /app/practice-two-0.0.1-SNAPSHOT.jar

#If your Spring Boot application listens on a specific port (e.g., 8080), you can expose that port in the Dockerfile
EXPOSE 8081

# Start the app using java command
CMD ["java", "-jar", "practice-two-0.0.1-SNAPSHOT.jar"]