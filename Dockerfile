#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

#
# Package stage
#
FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE
COPY --from=build /home/app/target/*-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=ocp","/usr/local/lib/app.jar"]
EXPOSE 8081/tcp

