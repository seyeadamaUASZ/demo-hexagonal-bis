pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	tools {
		jdk 'java-17'
	}

	stages {

		stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}

	// 	stage('sonar quality'){
	// 	steps {
	// 	   withSonarQubeEnv(installationName:'sonarqube'){
    //                bat 'mvn clean install -DskipTests org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar -Dsonar.java.binaries=target/classes'
    //        }
	// 	}
	// }

	//stage('Deploy jar to nexus repo') {
       // steps {
           // bat "mvn jar:jar deploy:deploy"
        //}
    //}

	// stage('Docker and push'){
	//     steps{
	//         bat 'mvn clean compile jib:build'
	//     }
	// }

	stage('deploy app to kubernetes cluster'){
           steps {
              bat 'cd k8s'
             //script {
                //kubernetesDeploy(configs: "postgres-deployment.yml","start-domain.yml")
             //}
             bat 'kubectl apply -f .'
           }
        }
	}
}