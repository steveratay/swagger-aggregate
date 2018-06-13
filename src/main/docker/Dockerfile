FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD maven/swagger-aggregate-*.jar /opt/swagger-aggregate.jar
RUN sh -c 'touch /opt/swagger-aggregate.jar' && \
    addgroup -S appuser && \
    adduser -S -g appuser appuser
USER appuser
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx512m", "-jar", "/opt/swagger-aggregate.jar"]