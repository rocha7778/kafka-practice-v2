FROM maven AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package




FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /home/app/target/product-command-service-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]









# docker build -t app-rest-not-kafka:v2.0 . --label "not-kafka"
# docker create -p 8080:8080 --name web-rest-api  app-rest:v1.0
# docker run -it --rm -p 8080:8080  --name web-rest-api  app-rest:v1.0
# docker  tag app-rest-not-kafka:v2.0   rocha7778/app-rest-not-kafka:v2.0
# docker push rocha7778/app-rest-not-kafka:v2.0
# kubectl port-forward pod/web-java 8080:8080
# 

# mysql

# docker create -p 3306:3306 --name mysql-product-command -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=product mysql 
# docker network disconnect  cqrs  mysql-product-comman
# docker create -p 3306:3306 --name mysql-product-query  mysql  
# use product;
# select * from product.product_command;
