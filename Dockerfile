FROM maven:3.6.3-jdk-8

ADD . /usr/src/originalapp
WORKDIR /usr/src/originalapp
EXPOSE 8080
ENTRYPOINT ["mvn", "clean", "verify", "exec:java"]