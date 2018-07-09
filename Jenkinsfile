node {

    stage('Clone Repository') {
        // Get some code from a GitHub repository
        sh 'cd ~/leviheidrick.com'
        sh "git pull https://github.com/heidricklevi/leviheidrick.com.git"

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