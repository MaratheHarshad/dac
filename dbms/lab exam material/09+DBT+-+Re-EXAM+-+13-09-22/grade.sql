/*
4. WRITE A FUNCTION TO TAKE THE INPUT AS MARK AND RETURN THE GRADE.
GRADE IS A IF MARK IS 80 AND ABOVE
ELSE GRADE IS B IF MARK IS IN RANGE 65 TO 80
ELSE GRADE IS C IF MARK IS IN RANGE 50 TO 64
OTHERWISE, FAIL IF MARK < 50.

09+DBT+-+Re-EXAM+-+13-09-22grade.sql

09+DBT+-+Re-EXAM+-+13-09-22/grade.sql
09+DBT+-+Re-EXAM+-+13-09-22\grade.sql
D:\Folders\dac\pg-dac\dac\dbms\lab exam material\09+DBT+-+Re-EXAM+-+13-09-22\grade.sql
D:\Folders\dac\pg-dac\dac\dbms\lab exam material\09+DBT+-+Re-EXAM+-+13-09-22\grade.sql
*/

DROP FUNCTION IF EXISTS grade;

DELIMITER &&

CREATE FUNCTION grade(marks int)
RETURNS VARCHAR(5)
DETERMINISTIC

BEGIN

     DECLARE result VARCHAR(5);

     IF marks >= 80 THEN
        SET result = 'A';
     ELSEIF marks >= 65 THEN
        SET result = 'B';
     ELSEIF marks > 50 THEN
        SET result = 'C';
     ELSE 
        SET result = 'FAIL';
     END IF;

     return (result);

END &&

DELIMITER ;



