FROM openjdk:17
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","app.jar"]
