pipeline {
  agent any
   environment {
      JAVA_HOME = 'C:/Java/jdk-11'
    }
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