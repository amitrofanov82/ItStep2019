SELECT FIRSTNAME, LASTNAME, CITY  FROM CUSTOMERS;
SELECT *  FROM CUSTOMERS;
SELECT   city, age FROM customers 
SELECT   id, firstname FROM customers WHERE age < 30 AND city = 'Minsk'


SELECT  count(*) , firstname
FROM customers 
WHERE 
    (age < 30 AND city = 'Minsk') 
    OR 
    (city!='Minsk') 
GROUP BY firstname;

SELECT   *
FROM customers 
WHERE 
    (age < 30 AND city = 'Minsk') 
    OR 
    (city!='Minsk') 
ORDER BY city DESC;


SELECT TOP 2 * FROM customers;


SELECT * FROM 
	(SELECT 
	         ID as номер_Заключенного,    LASTNAME as familia,       
	         FIRSTNAME as имя, ADDRESS,  CITY,  AGE, ISVIP 
	FROM customers 
	         where age > 16 
	) 
WHERE НОМЕР_ЗАКЛЮЧЕННОГО >4;


--delete from customers where ....; также как в селект


/*UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;*/

UPDATE customers
SET city = null, LastName= 'Бездомный'
WHERE city = 'Maskva' OR city = 'Tronto';

INSERT INTO users(birthday) VALUES(TO_DATE('17/12/2015', 'DD/MM/YYYY'));
SELECT * FROM users 
WHERE birthday > TO_DATE('17/12/1980', 'DD/MM/YYYY') AND birthday < TO_DATE('17/12/1990', 'DD/MM/YYYY');

SELECT * FROM users 
WHERE birthday  BETWEEN TO_DATE('17/12/1980', 'DD/MM/YYYY')  AND TO_DATE('17/12/1990', 'DD/MM/YYYY');





































