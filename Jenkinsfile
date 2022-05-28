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

       sh 'echo ishladi'
       sh 'pwd'
      }
    }

//     stage("docker run") {
//       steps{
//        sh 'docker-compose -f ~/var/lib/jenkins/workspace/test/docker-compose.yml pull dbup'
//       }
//     }
}
}
