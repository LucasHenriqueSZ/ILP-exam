FROM openjdk:22-jdk-slim AS builder

RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk-slim
WORKDIR /web_library

COPY --from=builder /app/target/web_library-0.0.1-SNAPSHOT.jar /web_library/app.jar

EXPOSE 80

CMD ["java", "-XX:+UseContainerSupport", "-jar", "/web_library/app.jar", "--server.port=80"]
