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