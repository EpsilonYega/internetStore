FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine
LABEL autors = "TERRISS"
LABEL version = "1.0"
LABEL maintain = "TERRISS"
COPY src/main/java .
WORKDIR /java
EXPOSE 8080
ENV GRADLE_HOME=/app/gradle-8.2
ENV PATH=$PATH:$GRADLE_HOME/bin/sh
CMD ["java", "-jar", "build/libs/internetStore.jar"]