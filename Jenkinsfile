pipeline {
  agent any
  tools {
    maven 'mavenmy'
  }
  stages {
    stage ('Tests') {
      steps {
        bat 'mvn clean test'
      }
    }
  }
}