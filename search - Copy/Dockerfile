FROM anapsix/alpine-java
ADD target/search-0.0.1-SNAPSHOT.jar search.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "search.jar"]


