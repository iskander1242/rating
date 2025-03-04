# Основной образ Jenkins
FROM jenkins/jenkins:lts

# Обновляем систему и устанавливаем docker-compose
USER root
RUN apt-get update && apt-get install -y docker-compose
USER jenkins