node {

    stage('Clone Repository') {
        // Get some code from a GitHub repository
        dir ('leviheidrick.com'){
        //sh 'pwd; la -l;'
            sh "git fetch --all"
            sh "git reset --hard origin/dev"
        }
    }


    stage('run npm') {
        dir ("leviheidrick.com") {
            sh 'cd frontend && npm install && npm run build'
        }
    }

    stage('Maven Clean') {
        sh 'cd leviheidrick.com && mvn clean install'
    }

}