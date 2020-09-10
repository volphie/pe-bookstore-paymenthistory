FROM openjdk:8u212-jdk-alpine
COPY target/paymenthistory-0.0.1-SNAPSHOT app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xmx400M","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]
