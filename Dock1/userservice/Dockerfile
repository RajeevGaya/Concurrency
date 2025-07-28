FROM openjdk:17
WORKDIR /appContainer
COPY ./target/UserService.jar /appContainer
EXPOSE 9191
CMD [ "java","-jar","UserService.jar" ]