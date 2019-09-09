FROM anapsix/alpine-java
ADD target/admin-0.0.1-SNAPSHOT.jar admin.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "admin.jar"]