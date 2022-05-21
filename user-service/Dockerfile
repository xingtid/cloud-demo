FROM openjdk:11
COPY ./app.jar /tmp/app.jar
COPY ./application.yml /config/application.yml
COPY ./bootstrap.yml /config/bootstrap.yml
VOLUME /tmp
EXPOSE 8083
ENTRYPOINT ["java","-jar","/tmp/app.jar","--spring.config.location=/home/config/application.yml","--spring.cloud.bootstrap.location=/home/config/bootstrap.yml"]
