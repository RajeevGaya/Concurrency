FROM openjdk:17
WORKDIR /appContainer
COPY ./target/spring-docker.jar /appContainer
EXPOSE 8282
CMD [ "java","-jar","spring-docker.jar" ]