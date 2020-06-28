def call(Map stageParams) {


       node {
                 checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
         
    ])
        git url:  stageParams.url
   stage("clean") {
            bat "mvn clean"
        }
        stage("Compile") {
            bat "mvn compile"
        }

        stage("Test") {
            bat "mvn test"
        }
        stage("install") {
            bat "mvn install"
        }
              stage("package") {
            bat "mvn package"
        }
      stage("deploy") {
            echo "mvn deploy"
        }
    }
  }
