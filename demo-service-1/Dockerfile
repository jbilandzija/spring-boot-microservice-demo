FROM openjdk:8-alpine
VOLUME /tmp
ADD target/demo-spring-boot-microservices-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8088
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]