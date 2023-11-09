CREATE TABLE PRODUCT (
    id int not null AUTO_INCREMENT,
    name varchar(100),
    description varchar(100),
	price long, 
	quantity long,
	PRIMARY KEY (id)
   
);

insert into product(id, name,description,price,quantity) values(1,'Ritchie', 'National Web Specialist', 52.74,20.0);
insert into product(id, name,description,price,quantity) values(2,'Ritchie', 'National Web Specialist', 52.74,20.0);