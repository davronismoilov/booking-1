pipeline {
  environment {
    imagename = "jenkinstest"
    registryCredential = 'test'
    dockerImage = ''
  }
  tools{
    maven '3.8.5'
  }
  agent any
  stages {


    stage("package") {
      steps{
       sh 'mvn clean install'
       sh 'echo ishladi'
       sh 'pwd'
      }
    }

    stage("docker run") {
      steps{
     sh 'docker-compose up --build'

      }
    }
}
}
