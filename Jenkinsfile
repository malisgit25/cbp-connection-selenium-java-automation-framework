pipeline {
    agent any

    tools {
        maven 'Maven3.9.11'
        jdk 'JDK21'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo 'Automation tests passed successfully'
        }

        failure {
            echo 'Automation tests failed'
        }
    }
}