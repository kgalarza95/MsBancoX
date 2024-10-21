
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/ms-clientes-x-0.0.1-SNAPSHOT.jar /app/clientes-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "clientes-service.jar"]
