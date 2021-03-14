FROM maven:3.6.0-jdk-8-slim AS build
WORKDIR .
RUN  mvn install
CMD ["mvn","test"]

##
## Package stage
##
#FROM openjdk:8-jre-slim
#COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]