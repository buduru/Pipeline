pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/<your-username>/myapp.git', branch: 'main'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Staging') {
            steps {
                sh 'scp target/myapp.war ubuntu@<staging-ec2-ip>:/var/lib/tomcat9/webapps/myapp.war'
            }
        }

        stage('Approval') {
            steps {
                input message: 'Approve deployment to production?', submitter: 'admin'
            }
        }

        stage('Deploy to Production') {
            steps {
                sh 'scp target/myapp.war ubuntu@<production-ec2-ip>:/var/lib/tomcat9/webapps/myapp.war'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
