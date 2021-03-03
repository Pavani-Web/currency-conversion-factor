FROM openjdk:8-jdk-alpine
RUN addgroup -S currencyfactor && adduser -S currencyfactor -G currencyfactor
USER currencyfactor:currencyfactor
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]