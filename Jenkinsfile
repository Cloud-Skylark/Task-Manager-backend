pipeline {
    agent { label 'xiya' }

    environment {
        DOCKER_USER = "devcloudy"
        IMAGE_NAME = "task-manager-application"
        DOCKER_IMAGE = "${DOCKER_USER}/${IMAGE_NAME}:${env.BUILD_ID}"
        LATEST_IMAGE = "${DOCKER_USER}/${IMAGE_NAME}:latest"
        NAMESPACE = "task-manager"
    }

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/Cloud-Skylark/Task-Manager-backend.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        stage('SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "mvn sonar:sonar -Dsonar.projectKey=${IMAGE_NAME}"
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} -t ${LATEST_IMAGE} ."
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh "echo \$PASS | docker login -u \$USER --password-stdin"
                    sh "docker push ${DOCKER_IMAGE}"
                    sh "docker push ${LATEST_IMAGE}"
                }
            }
        }

        stage('Deploy Postgres') {
            steps {
                sh "kubectl apply -f k8s/postgres/"
                sh "sleep 25"
            }
        }

        stage('Deploy Backend') {
            steps {
                sh "kubectl apply -f k8s/app/"
                sh "kubectl rollout restart deployment backend -n ${NAMESPACE}"
                sh "kubectl rollout status deployment backend -n ${NAMESPACE}"
            }
        }

    }
}