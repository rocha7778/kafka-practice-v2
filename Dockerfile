#FROM maven:3.6.3-openjdk-17 AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#RUN ls /home/app

# Environment variables for configuring the MySQL connection





FROM openjdk:17-jdk-slim
#COPY --from=build /home/app/target/product-command-service-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]

# mvn spring-boot:run -Dspring-boot.run.arguments=--spring.main.banner-mode=off,--customArgument=custom

ENV DB_HOST=mysql-product-command
ENV DB_PORT=3306
ENV DB_NAME=product
ENV DB_USER=root
ENV DB_PASSWORD=123456


EXPOSE 8080
ADD target/product-command-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]





# docker build -t app-rest:v2.0 .
# docker create -p 8080:8080 --name web-rest-api-v2  --network cqrs app-rest:v2.0


# to run and see the log inmediatelly
# docker run -it --rm --network cqrs -p 8080:8080  --name web-rest-api   app-rest:v2.0

# docker container run --network cqrs --name web-rest-api -p 8080:8080 -d app-rest:v2.0
# docker  tag app-rest:v2.0   rocha7778/app-rest:v2.0
# docker push rocha7778/app-rest:v2.0
# kubectl port-forward pod/web-java 8080:8080
# docker exec -it web-rest-api bash
# 

# mysql

# docker create -p 3306:3306 --name mysql-product-command --network cqrs  -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=product mysql 
# use product;
# select * from product.product_command;
