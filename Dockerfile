# Use an Java runtime as a parent image
FROM openjdk:18-ea-8-jdk-slim

# Set the working directory in the container
WORKDIR /app

# This command copies the JAR file from the target directory on your local machine (which is where Maven places the built JAR by default) to the /app directory in the container, renaming it to demo.jar.
COPY target/hello-world-0.0.1-SNAPSHOT.jar /app/demo.jar

# Run the jar file
ENTRYPOINT ["java","-jar","demo.jar"]