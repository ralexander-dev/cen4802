FROM eclipse-temurin:24-jre
WORKDIR /app
RUN useradd --system --create-home appuser
COPY target/*.jar app.jar
RUN mkdir -p logs && chown appuser:appuser logs
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]