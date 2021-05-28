FROM maven:3.8.1-jdk-11

RUN mkdir /application
RUN mkdir /var/maven
WORKDIR /application

ARG user_id=1000
ARG group_id=1000
RUN groupadd maven -g $group_id && \
    useradd -u $user_id -g maven -m -d /home/maven -s /sbin/nologin maven
RUN chown maven:maven -R /application
RUN chown maven:maven -R /var/maven

USER maven
