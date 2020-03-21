FROM centos:centos7
#Dockerfile for Jenkins container creation
#MAINTAINER André Pereira César Chagas - apchagas81@gmail.com

# updating centos packages and installing needed dependencies
RUN yum update -y
RUN yum install -y unzip wget net-tools vim git

#Sending needed depedencies into the container
COPY $HOME/essencials/* /tmp

# Configuring JAVA and JENKINS
RUN mkdir -p /opt/app
RUN cd /tmp && tar zxvf jdk1*.tar.gz -C /opt/app
RUN cd /tmp && unzip apache-tomcat-8.5.51.zip -d /opt/app && mv /opt/app/apache-tomcat-8.5.51 /opt/app/apache-tomcat
RUN chmod +x /opt/app/jdk1*/bin*
RUN chmod +x /opt/app/jdk1*/jre/bin*
RUN chmod +x /opt/app/apache-tomcat/bin*
RUN echo "export JAVA_HOME=/opt/app/jdk1.8.0_241/" >> $HOME/.bash_profile
RUN echo "export HISTTIMEFORMAT="%d|%m|%Y| %T " >> $HOME/.bash_profile
RUN echo "export PATH=$JAVA_HOME/bin:$PATH " >> $HOME/.bash_profile
RUN source ~/.bash_profile
RUN echo "Testing JAVA installation..."
RUN /opt/app/jdk1*/bin/java -version
RUN echo $JAVA_HOME
RUN chmod +x /etc/profile.d/*

# Cleaning temporary folder
RUN cd /tmp && rm -rf *

# Exposing at least HTTP and JENKINS Application ports for this profile
EXPOSE 80 8080

CMD /bin/bash

# Script for Jenkins CI startup |startjks.sh|
# CMD ["startjks.sh"]