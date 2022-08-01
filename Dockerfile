FROM openjdk:17-alpine
VOLUME /main-app
ADD /target/education-dlukin-api-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]