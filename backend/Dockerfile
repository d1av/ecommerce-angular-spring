FROM eclipse-temurin:17-jdk-alpine
WORKDIR /
VOLUME /tmp
COPY target/*.jar shop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","shop-0.0.1-SNAPSHOT.jar"]
EXPOSE $PORT
