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

    stage("test"){
    steps{
    sh 'mvn test'

     }
    }


    stage("package") {
      steps{
       sh 'mvn clean install'

       sh 'pwd'

       sh 'java -jar /var/lib/jenkins/workspace/test/target/eureka-server.jar & disown'
      }
    }

    stage("docker run") {
      steps{
//      sh 'docker-compose ps'
//      sh 'docker-compose rm'
//      sh 'docker-compose build'
//      sh 'docker-compose up -d'

      }
    }
}
}
