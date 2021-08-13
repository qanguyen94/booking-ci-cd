pipeline {
    agent {
        kubernetes {
            podRetention onFailure()
        }
    }

    stages {
        stage('Checkout project') {
            steps {
                script {
                   git branch: 'main',
                       url: 'https://github.com/qanguyen94/booking-ci-cd.git'
                }
            }
        }
        stage('Build project') {
            steps {
                script {
                    sh "echo 'Start building resource'"
                    sh "./gradlew build"
                }
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    dockerImage = docker.build "qanguyen/booking:v2.0.0"
                }
            }
        }
        stage('Push image') {
            steps {
                script {
                    // Assume the Docker Hub registry by passing an empty string as the first parameter
                    docker.withRegistry('' , 'dockerhub') {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploy kubernetes') {
            steps {
                script {
                    kubernetesDeploy(configs: "kubernetes", kubeconfigId: "")
                }
            }
        }
    }
}
