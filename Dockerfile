FROM eclipse-temurin:17-jdk-alpine
COPY build/libs/*.jar mym-email-and-notification-service.jar
ENTRYPOINT ["java", "-jar", "/mym-email-and-notification-service.jar"]