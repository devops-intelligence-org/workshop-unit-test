# Usa una imagen base de OpenJDK
FROM openjdk:24-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/workshop-unit-test-0.0.1-SNAPSHOT.jar /app/workshop-unit-test-0.0.1-SNAPSHOT.jar

# Exponer puerto en el que la aplicación escucha
EXPOSE 8080

# comando para ejecutar aplicación
CMD ["java", "-jar", "workshop-unit-test-0.0.1-SNAPSHOT.jar"]