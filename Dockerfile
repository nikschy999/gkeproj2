FROM openjdk:17
ENV APP_HOME=/usr/app/
WORKDIR ${APP_HOME}
COPY build/libs/*.jar app.jar
EXPOSE 8002
CMD ["java","-jar","app.jar"]