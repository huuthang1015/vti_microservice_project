FROM openjdk:17-jdk
LABEL authors="huuth"

WORKDIR /app

COPY target/account-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8081

ENTRYPOINT ["top", "-b"]