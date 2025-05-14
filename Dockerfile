FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/spring-security-1.0.jar /app/spring-security-1.0.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "spring-security-1.0.jar"]