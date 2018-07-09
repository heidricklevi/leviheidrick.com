node {

    stage('Clone Repository') {
        // Get some code from a GitHub repository
        sh 'cd ~/leviheidrick.com'
        sh 'ls'
        sh "git fetch --all"
        sh "git reset --hard origin/dev"

    }
    stage('run npm') {

        sh 'cd frontend'
        sh 'npm install'
        sh 'npm run build'
        sh 'cd ..'
    }

    stage('Maven Clean') {

        sh 'mvn clean install'
    }

}