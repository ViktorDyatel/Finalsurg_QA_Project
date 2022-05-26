pipeline {
   agent any

   tools {
      // Install the Maven version configured as "MAVEN 3.8.5" and add it to the path.
      maven "MAVEN 3.8.5"
      jdk "JAVA 8"
   }
    triggers {
        cron('0 8 * * *')
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }
   stages {
      stage('Testing') {
         steps {
            // Get some code from a GitHub repository
            git branch: "${params.BRANCH}", url: 'https://github.com/ViktorDyatel/Finalsurg_QA_Project_New.git'

            // Run Maven on a Unix agent.

            // To run Maven on a Windows agent, use
            bat "mvn -Dmaven.test.failure.ignore=true -Demail=${email} -Dpassword=${password} -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml clean test"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
      }
      stage('Generating Allure Report') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
        }
   }
}
