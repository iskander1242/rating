pipeline {
    agent any
    environment {
        SERVICE_NAME = "rating-service"
        REPO_URL = "https://github.com/iskander1242/rating.git"
        COMPOSE_FILE = "/workspace/ratingRoot/docker-compose.yml" // Путь внутри контейнера
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'develop', url: "${REPO_URL}"
                }
            }
        }
        stage('Stop Service') {
            steps {
                script {
                    if (isUnix()) {
                        sh "docker-compose -f ${COMPOSE_FILE} stop ${SERVICE_NAME}"
                    } else {
                        bat "docker-compose -f ${COMPOSE_FILE} stop ${SERVICE_NAME}"
                    }
                }
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    if (isUnix()) {
                        sh "docker-compose -f ${COMPOSE_FILE} build ${SERVICE_NAME}"
                    } else {
                        bat "docker-compose -f ${COMPOSE_FILE} build ${SERVICE_NAME}"
                    }
                }
            }
        }
        stage('Start Service') {
            steps {
                script {
                    if (isUnix()) {
                        sh "docker-compose -f ${COMPOSE_FILE} up -d ${SERVICE_NAME}"
                    } else {
                        bat "docker-compose -f ${COMPOSE_FILE} up -d ${SERVICE_NAME}"
                    }
                }
            }
        }
    }
    triggers {
        pollSCM('H/5 * * * *') // Проверка каждые 5 минут
    }
}