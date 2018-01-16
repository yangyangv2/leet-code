# Write your MySQL query statement below

Select

d.Name Department, e.Name Employee, e.Salary Salary

from Employee e,
    (select DepartmentID, max(Salary) as max from Employee group by DepartmentId) as m,
    Department d

where
    e.departmentid = m.DepartmentId and
    e.Salary = m.max and
    e.departmentid = d.id;
