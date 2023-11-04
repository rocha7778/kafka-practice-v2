FROM maven:3.6.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app

ENV MYSQL_DATABASE=product
ENV MYSQL_HOST=mysql-product-command
ENV MYSQL_PORT=3306
ENV MYSQL_USERNAME=root
ENV MYSQL_ROOT_PASSWORD=123456
ENV SPRING_PROFILES_ACTIVE=prod

RUN mvn -f /home/app/pom.xml clean package -DskipTests=true


FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/product-command-service-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]


# network
# docker network create rocha


# docker build -t app-product-service:v1.0 .
# docker create -p 8080:8080 --name web-rest-api  --network rocha app-product-service:v1.0
# docker start web-rest-api
# docker logs web-rest-api -f
# docker rm web-rest-api
# docker rmi app-product-service:v1.0



# docker run -it --rm -p 8080:8080  --name app-product-service app-product-service:v1.0
# docker  tag app-product-service:v1.0   rocha7778/app-product-service:v1.0
# docker push rocha7778/app-product-service:v1.0
# kubectl port-forward pod/web-java 8080:8080
# 

# mysql

# docker create -p 3306:3306 --name mysql-product-command --network rocha  -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=product mysql 
# docker start mysql-product-command
#docker inspect mysql-product-command

