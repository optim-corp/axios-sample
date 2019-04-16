FROM maven:3-jdk-8-alpine
ADD . /code/
RUN echo "Build jar" && \
    echo '{ "allow_root": true }' > /root/.bowerrc && \
    cd /code/axios-server && \
    mvn clean package -DskipTests && \
    mv /code/axios-server/target/*.jar /app.war

FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SLEEP=0 \
    JAVA_OPTS=""

ENV PORT 8080
EXPOSE 8080

RUN apk update && apk upgrade \
    && apk --update add tzdata nss \
    && apk add --no-cache git
CMD echo "The application will start in ${SLEEP}s..." && \
    sleep ${SLEEP} && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.war
COPY --from=0 /app.war .