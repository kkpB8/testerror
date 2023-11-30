FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar 
ADD target/UserManagement-0.0.1-SNAPSHOT.jar .jar
COPY ${JAR_FILE} UserManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserManagement-0.0.1-SNAPSHOT.jar"]
