
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/ms-cuentas-movimientos-x-0.0.1-SNAPSHOT.jar /app/cuentas-movimientos-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "cuentas-movimientos-service.jar"]
