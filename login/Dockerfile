FROM openjdk:8
ADD target/login-0.0.1-SNAPSHOT.jar login.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "login.jar"]