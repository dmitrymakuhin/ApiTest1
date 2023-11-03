pipeline {
  agent any
  tools {
    maven 'maven-3.6.3'
  }
  stages {
    stage ('Tests') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
}