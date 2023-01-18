FROM amazoncorretto:8
MAINTAINER guscata
COPY target/pgc-0.0.1-SNAPSHOT.jar pgc-app.jar
ENTRYPOINT ["java","-jar","/pgc-app.jar"]
