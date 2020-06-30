#!groovy

//branches
def feature="feature/*"
def devl = "develop"
def qual = "release/*"
def prod = "master"

//ports
def devl_port=9001
def qual_port=9002
def prod_port=9000

//container names
def devl_container="studentlistsample-dev"
def qual_container="studentlistsample-qa"
def prod_container="studentlistsample"

//environment yml file
def qa_yml="qa"
def dev_yml="dev"
def prod_yml="prod"

pipeline {
    agent any

    stages {

        stage("Feature Unit test and Build") {
            when{ branch feature }
            agent any
            steps {
                runBuild()
            }
        }

        stage("Devl Unit test and Build") {
            when{ branch devl }
            agent { label 'devl' }
            steps {
                runBuild()
            }
        }
        stage("Devl Deploy") {
            when{ branch devl }
            agent { label 'devl' }
            steps {
                sh "chmod +x jenkins/scripts/deploy.sh && ./jenkins/scripts/deploy.sh ${devl_container} ${devl_port} ${dev_yml}"

            }
        }
        stage("Qual Unit test and Build") {
            when{ branch qual }
            agent { label 'devl' }
            steps {
                runBuild()
            }
        }
        stage("Qual Deploy") {
            when{ branch qual }
            agent { label 'devl' }
            steps {
                sh "chmod +x jenkins/scripts/deploy.sh && ./jenkins/scripts/deploy.sh ${qual_container} ${qual_port} ${qa_yml}"
            }
        }

        stage("Prod Unit test and Build") {
            when{ branch prod }
            agent { label 'master' }
            steps {
                runBuild()
            }
        }
        stage("Prod Deploy") {
            when{ branch prod }
            agent { label 'prod' }
            steps {
                sh "chmod +x jenkins/scripts/deploy.sh && ./jenkins/scripts/deploy.sh ${prod_container} ${prod_port} ${prod_yml}"
            }
        }
    }
}

def runBuild(){
    sh "chmod +x gradlew && ./gradlew clean build --refresh-dependencies"
}