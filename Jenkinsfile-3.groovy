def ROLES = ['Backend': ["Spring Boot", "Node JS"], 'Frontend': ["ReactJs", "Angular"]]
def ALL_ROLES = ROLES.keySet() as ArrayList
pipeline {
    agent any

    parameters {
        choice(name: 'CHOICE', choices: ALL_ROLES, description: 'Pick something')
        choice(name: 'COURSE', choices: ROLES[$ { params.CHOICE }], description: 'Pick something')
    }
    stages {
        stage('Example') {
            steps {
                echo "Choice: ${params.CHOICE}"
                echo "COURSE: ${params.COURSE}"
            }
        }
    }
}
