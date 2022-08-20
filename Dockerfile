FROM openjdk:11
EXPOSE 8080
COPY build/libs/monitor-sensors-project-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "monitor-sensors-project-0.0.1-SNAPSHOT.jar"]
