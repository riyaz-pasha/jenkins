pipeline {
    agent any

    parameters {
        list = []
        for (subPath in createFilePath("${workspace}").list()) {
            list << subPath.getName()
            // in case you don't want extension
            list << FilenameUtils.removeExtension(subPath.getName())
        }
        choice(name: 'CHOICE', choices: list, description: 'Pick something')
    }
    stages {
        stage('Example') {
            steps {
                echo "Choice: ${params.CHOICE}"
            }
        }
    }
}
