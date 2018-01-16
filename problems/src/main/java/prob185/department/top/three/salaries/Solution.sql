# Write your MySQL query statement below


select d1.Name Department, e1.Name Employee, e1.Salary Salary
from Employee e1
join Department d1
on e1.departmentid = d1.id
where 3 > (
    select count(distinct(e2.Salary)) from Employee e2
    where e2.Salary > e1.Salary and
    e2.departmentid = e1.departmentid
)
order by d1.Name asc, e1.Salary desc

