# Write your MySQL query statement below

# select () will fill with null if there is no result from ();
select (
    select num from number
    group by num
    having count(*) = 1
    order by num desc limit 1
) as num;
