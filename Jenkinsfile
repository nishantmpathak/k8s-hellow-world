pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'spring-boot-docker-k8s'
        DOCKER_TAG = 'latest'
        REGISTRY = 'docker.io'
        DOCKER_REGISTRY_URL = credentials('DOCKER_REGISTRY_URL')
        DOCKER_REGISTRY_USERNAME = credentials('DOCKER_REGISTRY_USERNAME')  // Jenkins secret text credential ID
        DOCKER_REGISTRY_PASSWORD = credentials('DOCKER_REGISTRY_PASSWORD')  // Jenkins secret text credential ID
        MY_PASS = credentials('MY_PASS')
    }

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Docker Version') {
            steps {
                script {
                    sh 'sudo docker --version'
                }
            }
        }
        stage('Docker Build & Push') {
            steps {
                script {

                    // Login to Docker registry using credentials passed as environment variables
                    sh "sudo docker login -u $DOCKER_REGISTRY_USERNAME -p $DOCKER_REGISTRY_PASSWORD $DOCKER_REGISTRY_URL"

                    // Build and push Docker image
                    sh "sudo docker build -t $DOCKER_REGISTRY_URL/demo-spring-boot-app:latest ."
                    sh "sudo docker push $DOCKER_REGISTRY_URL/demo-spring-boot-app:latest"
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
}
