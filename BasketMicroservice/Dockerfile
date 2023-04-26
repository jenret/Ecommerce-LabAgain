FROM maven:3.9-sapmachine-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#FROM tomcat:8-jdk8-openjdk
FROM tomcat:11.0.0-jdk17
COPY --from=build /home/app/target/BasketMicroservice.war /usr/local/tomcat/webapps/ROOT.war

ENV SERVER_PORT=8083
ENV MONGO_HOST=ecommercemongo
ENV MONGO_PORT=2707
ENV MONGO_DB=ShopDB
ENV EUREKA_HOST=ecommerceeureka