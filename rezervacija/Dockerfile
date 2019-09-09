FROM anapsix/alpine-java
ADD target/rezervacija-0.0.1-SNAPSHOT.jar rezervacija.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "rezervacija.jar"]