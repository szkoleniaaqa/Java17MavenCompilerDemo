pipeline {
   agent { docker { image 'mcr.microsoft.com/playwright:v1.33.0-jammy' } }
   stages {
      stage('e2e-tests') {
         steps {
            sh 'mvn clean test'
         }
      }
   }
}
