FROM maven:3-eclipse-temurin-17-noble AS prepared
WORKDIR /app
COPY . .
RUN ["mvn", "-B", "dependency:go-offline"]
RUN ["mvn", "-B", "package"]
FROM prepared AS test
RUN ["mvn", "-B", "test"]
FROM prepared AS runtime
USER 10001:10001
EXPOSE 8301
ENTRYPOINT []
CMD ["java", "-jar", "target/shipping-bands-0.1.0.jar"]
