pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}
pipelineJob('HelloWorldDockerApp-JOB') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/shivamdeep/HelloWorldDockerApp.git'
                    }
                    branch 'master'
                }
            }
        }
    }
}

pipelineJob('HelloWorldDockerApp-JOB-DOCKER') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/shivamdeep/HelloWorldDockerApp.git'
                    }
                    branch 'master'
                    scriptPath('Jenkinsfile-docker')
                }
            }
        }
    }
}

pipelineJob('HelloWorldDockerApp-JOB-AWS') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/shivamdeep/HelloWorldDockerApp.git'
                    }
                    branch 'master'
                    scriptPath('Jenkinsfile-aws')
                }
            }
        }
    }
}