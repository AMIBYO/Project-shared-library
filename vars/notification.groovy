import org.example.Constants

def call(Map config=[:]) {
    stage("Compile") {
    if (config.type == "slack") {
        echo Constants.SLACK_MESSAGE
        echo config.message
    } else {
        echo Constants.EMAIL_MESSAGE
        echo config.message
    }
}
}
