node {

    stage('Build') {
        // Get some code from a GitHub repository
        dir ('../com.leviheidrick'){
        //sh 'pwd; la -l;'
            sh "git fetch --all"
            sh "git reset --hard origin/dev"
            sh 'cd frontend && npm install && npm run build'
        }
    }


    stage('Test') {
        dir ("../com.leviheidrick") {
            sh 'mvn install'

        }
    }

    stage('Deploy') {
        dir ("../com.leviheidrick") {
            sh 'systemctl daemon-reload'
            sh 'service comleviheidrick restart'


        }
    }

}