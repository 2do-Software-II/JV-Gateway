# Usa una imagen base de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación Spring Boot (asegúrate de ajustar el nombre del archivo JAR según tu proyecto)
COPY target/hotel-0.0.1-SNAPSHOT.jar gateway.jar

# Define las variables de entorno directamente en el Dockerfile
ENV API_SYSTEM=https://jv-system-production.up.railway.app/api
ENV API_IA=https://hotel-sistema-4f1204453c98.herokuapp.com/
ENV API_DH=https://hotel-sistema-4f1204453c98.herokuapp.com/

# Expone el puerto en el que se ejecutará tu aplicación Spring Boot (ajusta según sea necesario)
EXPOSE 4000

# Comando para ejecutar la aplicación Spring Boot dentro del contenedor
CMD ["java", "-jar", "gateway.jar"]
