FROM azul/zulu-openjdk-alpine:11

EXPOSE 8080

ADD target/*-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]