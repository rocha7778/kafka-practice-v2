drop table if exists product;

CREATE TABLE PRODUCT (
    id int not null AUTO_INCREMENT,
    name varchar(100),
    description varchar(100),
	price long, 
	quantity long,
    CREATED_AT timestamp not null,
    UPDATED_AT timestamp not null,  
    IS_DELETED  boolean default false,
    DELETED_AT  timestamp,
	PRIMARY KEY (id)
);