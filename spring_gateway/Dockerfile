# Tomar el sistema base
FROM openjdk:17-slim
LABEL maintainer="jesuspenarrieta03@gmail.com"

ARG JAR_FILE
RUN echo ${JAR_FILE}
COPY ${JAR_FILE}/app.jar
ENTRYPOINT ["java","-jar","/app.jar"]