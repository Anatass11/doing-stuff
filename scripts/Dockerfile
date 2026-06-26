FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /build

# Копируем родительский POM
COPY ../pom.xml /build/pom.xml

# Копируем POM текущего модуля
COPY pom.xml /build/scripts/pom.xml

# Переходим в папку модуля
WORKDIR /build/scripts

# Кэшируем зависимости
RUN mvn dependency:go-offline

# Копируем исходники модуля
COPY src ./src

# Собираем
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Копируем JAR
COPY --from=build /build/target/*.jar app.jar

# Добавляем healthcheck
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# Оптимизация JVM для контейнеров
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]