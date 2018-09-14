node {

    stage('Build') {
        // Get some code from a GitHub repository
        dir ('../com.leviheidrick'){
        //sh 'pwd; la -l;'
            sh "sudo git fetch --all"
            sh "sudo git reset --hard origin/dev"
            sh 'cd frontend && sudo npm install && sudo npm run build'
        }
    }


    stage('Test') {
        dir ("../com.leviheidrick") {
            sh 'sudo mvn install'

        }
    }

    stage('Deploy') {
        dir ("../com.leviheidrick") {
            sh 'sudo systemctl daemon-reload'
            sh 'sudo service comleviheidrick restart'
        }
    }

}