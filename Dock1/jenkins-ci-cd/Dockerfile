FROM penjdk:17
WORKDIR /appContainer
COPY ./target/jenkinsCiCd.jar /appContainer
EXPOSE 8282
CMD ["java","-jar","jenkinsCiCd.jar"]