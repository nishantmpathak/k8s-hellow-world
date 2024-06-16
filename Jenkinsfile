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
                    sh "echo $MY_PASS | sudo -S /usr/local/bin/docker --version"
                }
            }
        }
        stage('Docker Build & Push') {
            steps {
                script {

                    // Login to Docker registry using credentials passed as environment variables
                    sh "echo $MY_PASS | sudo -S /usr/local/bin/docker login -u $DOCKER_REGISTRY_USERNAME -p $DOCKER_REGISTRY_PASSWORD "

                    // Build and push Docker image
                    sh "echo $MY_PASS | sudo -S /usr/local/bin/docker build -t demo-spring-boot-app:latest ."
                    sh "echo $MY_PASS | sudo -S /usr/local/bin/docker push $DOCKER_REGISTRY_USERNAME/demo-spring-boot-app:latest"
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                sh "cd K8S"
                sh "echo $MY_PASS | sudo -S /opt/homebrew/bin/kubectl apply -f deployment.yaml"
            }
        }
    }
}
