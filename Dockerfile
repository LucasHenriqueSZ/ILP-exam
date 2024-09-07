FROM openjdk:22

WORKDIR web_library

COPY target/*.jar /web_library/app.jar

EXPOSE 80

CMD java -XX:+UseContainerSupport -Xmx500m -jar app.jar --server.port=80