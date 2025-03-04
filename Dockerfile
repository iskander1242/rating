#FROM eclipse-temurin:17-jre-alpine
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#COPY ./target/*.jar app.jar
#COPY ./fonts app/fonts
#COPY ./jasperConfig app/jasperConfig
#ENTRYPOINT ["java","-jar","/app.jar"]

# Используйте официальный образ Maven как родительский образ
FROM eclipse-temurin:21.0.1_12-jdk-ubi9-minimal as build

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src src
#COPY fonts fonts
#COPY jasperConfig jasperConfig

RUN chmod +x ./mvnw
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21.0.1_12-jre-ubi9-minimal

COPY --from=build /app/target/*.jar app.jar
#COPY --from=build /app/fonts /app/fonts
#COPY --from=build /app/jasperConfig /app/jasperConfig

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java","-jar","/app.jar"]