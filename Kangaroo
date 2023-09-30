# Use a base image with Java and Maven pre-installed
FROM maven:3.8.3-openjdk-11-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files (pom.xml) to the container
COPY pom.xml .

# Copy the entire application source code to the container
COPY src ./src

# Build the application and create a JAR file
RUN mvn clean package

# Use a lighter-weight base image for the final image
FROM openjdk:11-jre-slim

# Set the working directory in the final container
WORKDIR /app

# Copy the JAR file from the build container to the final container
COPY --from=build ./app/target/*.jar ./app.jar

# Expose the port that your Spring application will run on
EXPOSE 7004

# Command to run the Spring application
CMD ["java", "-jar", "app.jar"]

# docker build -t ipsenh-be:1 --no-cache --progress=plain .
