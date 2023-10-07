FROM maven:3.6.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
RUN ls /home/app


FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/product-command-service-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]





# docker build -t app-rest:v1.0 .
# docker create -p 8080:8080 --name web-rest-api  app-rest:v1.0
# docker run -it --rm -p 8080:8080  --name web-rest-api  app-rest:v1.0
# docker  tag app-rest:v1.0   rocha7778/app-rest:v1.0
# docker push rocha7778/app-rest:v1.0
# kubectl port-forward pod/web-java 8080:8080
# 

# mysql

# docker create -p 3306:3306 --name mysql-product-command --network cqrs  -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=product mysql 
# docker create -p 3306:3306 --name mysql-product-query  mysql   --network cqrs
# use product;
# select * from product.product_command;
