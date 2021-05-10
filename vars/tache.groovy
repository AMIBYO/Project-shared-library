def call(Map stageParams) {


       node {
                 checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
         
    ])
        git url:  stageParams.url
   stage("clean") {
            sh "mvn clean"
        }
        stage("Compile") {
            sh "mvn compile"
        }

        stage("Test") {
            sh "mvn test"
        }
        stage("install") {
            sh "mvn install"
        }
              stage("package") {
            sh "mvn package"
        }
      stage("deploy") {
            echo "mvn deploy"
        }
    }
  }
