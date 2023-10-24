-- Q-1. Write an SQL query to fetch “FIRST_NAME” from Worker table using the alias name as <WORKER_NAME>.


--> select FIRST_NAME as WORKER_NAME from Worker;


-- Q-2. Write an SQL query to fetch “FIRST_NAME” from Worker table in upper case.

--> select upper(FIRST_NAME) from Worker


-- Q-3. Write an SQL query to fetch unique values of DEPARTMENT from Worker table.

-- using group by

--> select DEPARTMENT from Worker group by DEPARTMENT;




-- Q-4. Write an SQL query to print the first three characters of  FIRST_NAME from Worker table.


--> select left(FIRST_NAME, 3) from Worker;
--> select substring(FIRST_NAME,1, 3) from Worker;


-- Q-5. Write an SQL query to find the position of the alphabet (‘b’) in the first name column ‘Amitabh’ from Worker table.

-- select position('b' in FIRST_NAME) as Position from Worker where FIRST_NAME = "Amitabh";








-- Q-6. Write an SQL query to print the FIRST_NAME from Worker table after removing white spaces from the right side.


--> select rtrim(FIRST_NAME) from  Worker;


-- Q-7. Write an SQL query to print the DEPARTMENT from Worker table after removing white spaces from the left side.

--> select rtrim(DEPARTMENT) from  Worker;







-- Q-8. Write an SQL query that fetches the unique values of DEPARTMENT from Worker table and prints its length.

--> SELECT LENGTH(DEPARTMENT) FROM Worker group by DEPARTMENT;




-- Q-9. Write an SQL query to print the FIRST_NAME from Worker table after replacing ‘a’ with ‘A’.


-- > select replace(FIRST_NAME, 'a', 'A') from Worker;






-- Q-10. Write an SQL query to print the FIRST_NAME and LAST_NAME from Worker table into a single column COMPLETE_NAME.
-- A space char should separate them.


-- > select concat(FIRST_NAME, " ", LAST_NAME) as COMPLETE_NAME from Worker;






-- Q-11. Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending.

-- > select * from Worker order by FIRST_NAME;


-- Q-12. Write an SQL query to print all Worker details from the Worker table order by 
-- FIRST_NAME Ascending and DEPARTMENT Descending.


-- > select * from Worker order by FIRST_NAME asc, DEPARTMENT desc;



-- using Or
-- using In

-- Q-13. Write an SQL query to print details for Workers with the first name as “Vipul” and “Satish” from Worker table.

-- > select * from Worker where FIRST_NAME = "Vipul" or FIRST_NAME = "Satish";


-- > select * from Worker where FIRST_NAME in ("Satish", "Vipul");





-- Q-14. Write an SQL query to print details of workers excluding first names, “Vipul” and “Satish” from Worker table.

-- > select * from Worker where FIRST_NAME not in ("Satish", "Vipul");



-- Q-15. Write an SQL query to print details of Workers with DEPARTMENT name as “Admin*”.



-- > select * from Worker where DEPARTMENT in ("Admin");


-- Q-16. Write an SQL query to print details of the Workers whose FIRST_NAME contains ‘a’.


-- > select * from Worker where FIRST_NAME like "%a%";



    

-- Q-17. Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘a’.


-- > select * from Worker where FIRST_NAME like "%a";

-- or

-- > select  *  from Worker where right(FIRST_NAME, 1) = 'a';





-- Q-18. Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘h’ and contains six alphabets.



-- > select * from Worker where FIRST_NAME like "_____h";





-- Q-19. Write an SQL query to print details of the Workers whose SALARY lies between 100000 and 500000.


-- > select * from Worker where SALARY between 100000 and 500000;




-- Q-20. Write an SQL query to print details of the Workers who have joined in Feb’2014.


--> select * from Worker where year(JOINING_DATE) = 2014;




-- Q-21. Write an SQL query to fetch the count of employees working in the department ‘Admin’.


-- > select count(*) from Worker group by DEPARTMENT having DEPARTMENT = "Admin";






-- Q-22. Write an SQL query to fetch worker full names with salaries >= 50000 and <= 100000.

-- > select * from Worker where SALARY >= 50000 and SALARY <= 100000;





-- Q-23. Write an SQL query to fetch the no. of workers for each department in the descending order.

-- > select count(*) from Worker group by DEPARTMENT order by count(*);





-- Q-24. Write an SQL query to print details of the Workers who are also Managers.


-- > select * from Worker join Title on WORKER_ID = WORKER_REF_ID and WORKER_TITLE = "Manager";





-- Q-25. Write an SQL query to fetch number (more than 1) of same titles in the ORG of different types.


-- > select WORKER_TITLE, count(*) from Title group by WORKER_TITLE having count(*) > 1;





-- Q-26. Write an SQL query to show only odd rows from a table.
-- > select * from worker where MOD (WORKER_ID, 2) != 0; 


-- Q-27. Write an SQL query to show only even rows from a table. 

-- > select * from worker where MOD (WORKER_ID, 2) = 0; 




-- Q-28. Write an SQL query to clone a new table from another table.

-- >  create table Clone_Worker as select * from Worker;




-- Q-29. Write an SQL query to fetch intersecting records of two tables.


-- > select * from Clone_Worker intersect select * from Worker;

-- (selects same rows from both the tables)





-- Q-30. Write an SQL query to show records from one table that another table does not have.
-- MINUS

-- > select * from Clone_Worker where WORKER_ID not in ( select WORKER_ID from Worker );






-- Q-31. Write an SQL query to show the current date and time.
-- DUAL

-- > select sysdate() from dual;




-- Q-32. Write an SQL query to show the top n (say 5) records of a table order by descending salary.



-- > select * from Worker limit 5;




-- Q-33. Write an SQL query to determine the nth (say n=5) highest salary from a table.



-- > select * from Worker  order by SALARY desc limit 1 offset 4;





-- Q-34. Write an SQL query to determine the 5th highest salary without using LIMIT keyword.



-- > select * from (select * from Worker order by SALARY desc limit 5) as derived order by SALARY asc limit 1;






 
-- Q-35. Write an SQL query to fetch the list of employees with the same salary.








-- Q-36. Write an SQL query to show the second highest salary from a table using sub-query.


-- > select max(SALARY) from Worker where SALARY not in (select max(SALARY) FROM Worker);





-- third highest for homework

-- > select max(SALARY) from Worker where SALARY not in(select max(SALARY) from Worker UNION select max(SALARY) from Worker where SALARY not in (select max(SALARY) from Worker));






-- Q-37. Write an SQL query to show one row twice in results from a table.






-- Q-38. Write an SQL query to list worker_id who does not get bonus.








-- Q-39. Write an SQL query to fetch the first 50% records from a table.







-- Q-40. Write an SQL query to fetch the departments that have less than 4 people in it.






-- Q-41. Write an SQL query to show all departments along with the number of people in there.







-- Q-42. Write an SQL query to show the last record from a table.


-- Q-43. Write an SQL query to fetch the first row of a table.


-- Q-44. Write an SQL query to fetch the last five records from a table.




-- Q-45. Write an SQL query to print the name of employees having the highest salary in each department.




-- Q-46. Write an SQL query to fetch three max salaries from a table using co-related subquery

-- DRY RUN AFTER REVISING THE CORELATED SUBQUERY CONCEPT FROM LEC-9.


-- Q-47. Write an SQL query to fetch three min salaries from a table using co-related subquery


-- Q-48. Write an SQL query to fetch nth max salaries from a table.


-- Q-49. Write an SQL query to fetch departments along with the total salaries paid for each of them.





-- Q-50. Write an SQL query to fetch the names of workers who earn the highest salary.
