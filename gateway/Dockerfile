FROM openjdk:11
COPY ./gateway-1.0.jar /tmp/gateway-1.0.jar
COPY ./application.yml /config/application.yml
VOLUME /tmp
EXPOSE 10010
ENTRYPOINT ["java","-jar","/tmp/gateway-1.0.jar","--spring.config.location=/home/config/application.yml"]