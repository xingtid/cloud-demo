FROM openjdk:11
COPY ./user-service.jar /tmp/user-service.jar
COPY ./application.yml /config/application.yml
COPY ./bootstrap.yml /config/bootstrap.yml
VOLUME /tmp
EXPOSE 8083
ENTRYPOINT ["java","-jar","/tmp/user-service.jar","--spring.config.location=/home/config/application.yml","--spring.cloud.bootstrap.location=/home/config/bootstrap.yml"]
