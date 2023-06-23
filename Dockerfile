FROM openjdk:8-jdk-alpine
COPY target/buildAppSpringboot-0.0.1-SNAPSHOT.jar buildAppSpringboot.jar
ENTRYPOINT ["java", "-jar", "/buildAppSpringboot.jar"]