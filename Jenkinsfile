pipeline {
    agent any

    tools {
        maven '3.9.11'
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
        // Publish TestNG results
            junit 'target/surefire-reports/*.xml'
        }
        
        // Publish Extent Report in Jenkins UI
            publishHTML([
                reportDir: 'test-output',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent HTML Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
        

        success {
            echo 'Automation tests passed successfully'
        }

        failure {
            echo 'Automation tests failed'
        }
    }
}