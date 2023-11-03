pipeline {
  agent any
  tools {
    maven 'mavenmy'
  }
  stages {
    stage ('Tests') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
}