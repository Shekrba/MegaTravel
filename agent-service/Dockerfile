FROM anapsix/alpine-java
ADD target/login-0.0.1-SNAPSHOT.jar agent.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "agent.jar"]