pipeline {
    agent {
        kubernetes {
            yaml '''
              apiVersion: v1
              kind: Pod
              metadata:
                labels:
                  some-label: some-label-value
              spec:
                containers:
                - name: gradle
                  image: gradle:jre11
              '''
        }
    }

    stages {
        stage('Build project') {
            steps {
                sh "echo 'Start building resource'"
                sh "./gradlew build"
            }
        }
         stage('Build docker image') {
                 steps {
                     dockerImage = docker.build "qanguyen/booking:v2.0.0"
                 }
         }
         stage('Push image') {
                 steps {
                     // Assume the Docker Hub registry by passing an empty string as the first parameter
                     docker.withRegistry('' , 'dockerhub') {
                         dockerImage.push()
                     }
                 }
         }
         stage('Deploy kubernetes') {
                 steps {
                     kubernetesDeploy(configs: "kubernetes", kubeconfigId: "")
                 }
         }

    }
}
