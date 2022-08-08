// pipeline {
//   environment {
//     imagename = "jenkinstest"
//     registryCredential = 'test'
//     dockerImage = ''
//   }
//   tools{
//     maven '3.8.5'
//   }
//   agent any
//   stages {
//
//     stage("test"){
//     steps{
//     sh 'mvn test'
//
//      }
//     }
//
//
//     stage("package") {
//       steps{
//        sh 'mvn clean install'
//
//        sh 'pwd'
//
//
//       }
//     }
//
//     stage("docker run") {
//       steps{
//       sh 'java -jar /var/lib/jenkins/workspace/test/target/eureka-server.jar & disown'
// //      sh 'docker-compose ps'
// //      sh 'docker-compose rm'
// //      sh 'docker-compose build'
// //      sh 'docker-compose up -d'
//
//       }
//     }
// }
// }

node {
    stage 'Clone the project'
   // git 'https://github.com/eugenp/tutorials.git'

    dir('spring-jenkins-pipeline') {
        stage("Compilation and Analysis") {
            parallel 'Compilation': {
                sh "./mvnw clean install -DskipTests"
            }, 'Static Analysis': {
                stage("Checkstyle") {
                    sh "./mvnw checkstyle:checkstyle"

                    step([$class: 'CheckStylePublisher',
                      canRunOnFailed: true,
                      defaultEncoding: '',
                      healthy: '100',
                      pattern: '**/target/checkstyle-result.xml',
                      unHealthy: '90',
                      useStableBuildAsReference: true
                    ])
                }
            }
        }

        stage("Tests and Deployment") {
            parallel 'Unit tests': {
                stage("Runing unit tests") {
                    try {
                        sh "./mvnw test -Punit"
                    } catch(err) {
                        step([$class: 'JUnitResultArchiver', testResults:
                          '**/target/surefire-reports/TEST-*UnitTest.xml'])
                        throw err
                    }
                   step([$class: 'JUnitResultArchiver', testResults:
                     '**/target/surefire-reports/TEST-*UnitTest.xml'])
                }
            }, 'Integration tests': {
                stage("Runing integration tests") {
                    try {
                        sh "./mvnw test -Pintegration"
                    } catch(err) {
                        step([$class: 'JUnitResultArchiver', testResults:
                          '**/target/surefire-reports/TEST-'
                            + '*IntegrationTest.xml'])
                        throw err
                    }
                    step([$class: 'JUnitResultArchiver', testResults:
                      '**/target/surefire-reports/TEST-'
                        + '*IntegrationTest.xml'])
                }
            }

            stage("Staging") {
                sh "pid=\$(lsof -i:8989 -t); kill -TERM \$pid "
                  + "|| kill -KILL \$pid"
                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                    sh 'nohup ./mvnw spring-boot:run -Dserver.port=8989 &'
                }
            }
        }
    }
}
