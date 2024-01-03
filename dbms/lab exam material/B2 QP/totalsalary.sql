-- create a pl(pipeline)-function which takes department id/department name as input and return the total salary paid by that DEPT

drop function if exists totalsalary;

delimiter &&

create function totalsalary(deptName varchar(255))
returns int
deterministic

begin

    declare total int default 0;


    select sum(SALARY) into total from worker where DEPARTMENT = deptName;

    return (total);
end &&

delimiter ;