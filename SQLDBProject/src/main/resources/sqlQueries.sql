CREATE TABLE customers (
    id int NOT NULL,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255) ,
    Age int,
    IsVip boolean,
    CONSTRAINT customers_PK PRIMARY KEY(ID)
);
--ALTER TABLE ca-by-projectX.customers ADD PRIMARY KEY (id);
--ALTER TABLE customers ADD PRIMARY KEY (id);



CREATE TABLE goods (
    id int PRIMARY KEY,
    name varchar(255),
    description varchar(255),
    remains int
);
--ALTER TABLE GOODS ADD PRIMARY KEY (id);





INSERT INTO GOODS(ID, NAME, DESCRIPtion, REMAINS) 
	VALUES (1,'1','1', 1); 
	
INSERT INTO GOODS(ID, NAME,REMAINS) 
	VALUES (2,'1', 1); 

ALTER TABLE goods ALTER COLUMN NAME SET NOT NULL;

--INSERT INTO GOODS(ID, DESCRIPTION,REMAINS)  Tak nelzya
--	VALUES (3,'1', 1); 
	

DELETE FROM GOODS;

drop table customers;
drop table goods;