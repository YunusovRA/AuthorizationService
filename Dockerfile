# Базовый образ
FROM openjdk:21

# Открываем порт, на котором работает приложение (например, 8080)
EXPOSE 8080

# Копируем JAR-файл в контейнер
# Для Maven:
ADD target/AuthorizationService-0.0.1-SNAPSHOT.jar /app.jar

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "/app.jar"]