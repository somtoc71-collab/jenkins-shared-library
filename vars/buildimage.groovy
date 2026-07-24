#!/usr/bin/env groovy

def call() {
    echo 'building the image ..'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
    sh 'docker build -t bamzy14/my-repo:jma-2.0 .'
    sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
    sh 'docker push bamzy14/my-repo:jma-2.0'
    } 
}  
