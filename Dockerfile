FROM eclipse-temurin:23-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY ./src/main/resources/docs ./src/main/resources/docs
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]