pipeline {
      agent any
      stages {
            stage('Init') {
                  steps {
                        echo 'Hi, this is Andre CHAGAS from ACME-IT'
                        echo 'We are Starting the Testing'
                  }
            }
            stage('Build') {
                  steps {
                        bash '''
                        echo 'Building Sample Maven Project'
                        #!/bin/bash
                        mvn -version
                        '''
                  }
            }
            stage('Deploy') {
                  steps {
                        echo "Deploying in Staging Area"
                  }
            }
            stage('Deploy in Production') {
                  steps {
                        echo "Deploying in Production Area"
                  }
            }
      }
}
