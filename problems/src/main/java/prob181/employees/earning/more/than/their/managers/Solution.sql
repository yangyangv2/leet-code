# Write your MySQL query statement below

select Name as Employee

from Employee e1
where
    ManagerId is not NULL and
    Salary > (
        select Salary from Employee e2
        where e1.ManagerId = e2.id
    )