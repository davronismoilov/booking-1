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
      }
    }

//     stage("docker run") {
//       steps{
//        sh 'docker-compose -f ~/var/lib/jenkins/workspace/test/docker-compose.yml pull dbup'
//       }
//     }
}
}
