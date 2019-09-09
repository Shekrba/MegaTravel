FROM anapsix/alpine-java
ADD target/zuul.jar zuul.jar
EXPOSE 8762
ENTRYPOINT ["java", "-jar", "zuul.jar"]