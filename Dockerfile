FROM openjdk:8-jre-alpine

WORKDIR /app

VOLUME /app

COPY build/libs/*.jar studentlistsample.jar

ENTRYPOINT ["java","-jar","studentlistsample.jar"]