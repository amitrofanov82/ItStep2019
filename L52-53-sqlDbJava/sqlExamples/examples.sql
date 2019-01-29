--join same table:

SELECT name 
FROM employee e INNER JOIN employee shef
on e.chief_id = shef.id
WHERE e.salary > shef.salary

SELECT max(salary), department_id 
FROM employee INNER JOIN employee shef on employee.department_id = department.id
GROUP BY department_id

select LENGTH(oc_country.name) from oc_country

select * from anytable where anytable.anycolumn IN (SELECT ... );





































