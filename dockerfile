FROM openjdk:8-jdk-alpine
COPY "./target/RestFull-API-theMovieDB-test-0.0.1-SNAPSHOT.jar" "api-test.jar"
EXPOSE 8080
CMD ["java", "-jar", "api-test.jar"]
