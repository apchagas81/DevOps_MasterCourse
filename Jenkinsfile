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
                        sh ''' 
                        #!/bin/bash
                        echo $USER
                        echo 'Building Sample Maven Project'
                       
                        /opt/app/apache-maven/bin/mvn -version
                        '''
                        maven('clean package', 'maven-samples/single-module/pom.xml')
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
