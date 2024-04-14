FROM amazoncorretto:21
LABEL authors="georgekankava"
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY build/libs/apartments-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT exec java -jar app.jar