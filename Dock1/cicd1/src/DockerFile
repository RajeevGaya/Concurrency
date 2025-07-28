FROM openjdk:17
WORKDIR /appContainer
COPY ./target/jenkinsCiCD.jar /appContainer
EXPOSE 8282
CMD [ "java","-jar","jenkinsCiCD.jar" ]