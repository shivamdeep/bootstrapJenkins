FROM jenkins/jenkins:2.225

USER root
RUN curl -sSL https://get.docker.com/ | sh

# CMD DOCKER_GID=$(stat -c '%g' /var/run/docker.sock) && \
#     groupadd -for -g ${DOCKER_GID} docker && \
#     usermod -aG docker jenkins && \
#     sudo -E -H -u jenkins bash -c /usr/local/bin/jenkins.sh

#RUN usermod -a -G docker jenkins
#USER jenkins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY seedJob.xml /usr/share/jenkins/ref/jobs/seed-job/config.xml

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false