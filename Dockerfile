FROM openjdk:17
ADD target/springboot-sec-mongo-docker.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
EXPOSE 3003