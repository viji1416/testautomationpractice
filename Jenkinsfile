pipeline {
    agent any

    tools {
        git 'Default'
        maven 'Maven_3.9.6'
        jdk 'JDK21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/viji1416/testautomationpractice.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Reports') {
            steps {
                // JUnit XML summary
                junit '**/target/surefire-reports/*.xml'

                // TestNG HTML report
                publishHTML([
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report'
                ])
            }
        }
    }
}
