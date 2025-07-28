FROM openjdk:17
WORKDIR /myApp
COPY ./target/docker-mysql.jar /myApp/
EXPOSE 8181
CMD ["JAVA","-jar","docker-mysql.jar"]

