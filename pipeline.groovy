pipeline {
    agent any 

    stages { 
        stage('SCM Checkout') {
            steps {
                retry(3) {
                    git branch: 'main', url: 'https://github.com/anuththara29/4086-Naulla'
                }
            }
        }
        
        stage('Build Frontend Docker Image') {
            steps {  
                bat 'docker build -t frontend-image:13 -f web-app/Dockerfile web-app'
            }
        }
        
        stage('Build Backend Docker Image') {
            steps {  
                bat 'docker build -t backend-image:14 -f backend/Dockerfile backend'
            }
        }
   
        stage('Run Frontend Container') {
            steps {
                bat 'docker run -d -p 8085:80 frontend-image'
            }
        }

        stage('Run Backend Container') {
            steps {
                bat 'docker run -d -p 8086:3000 backend-image'
            }
        }
    }
    
    post {
        always {
            bat 'docker logout'
        }
    }
}