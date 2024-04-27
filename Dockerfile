# Use an image with JDK and Maven pre-installed
FROM maven:3.8.1-openjdk-11 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN mvn clean package

# Use a lighter base image for runtime
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage to the runtime image
COPY --from=builder /app/target/Sudoku-1.jar ./app.jar

# Expose the port your application runs on
EXPOSE 9876

# Command to run the application
CMD ["java", "-jar", "app.jar"]
