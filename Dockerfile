FROM amazoncorretto:8-jdk-alpine
MAINTAINER guscata
COPY target/pgc-0.0.1-SNAPSHOT.jar pgc-app.jar
ENTRYPOINT ["java","-jar","/pgc-app.jar"]
