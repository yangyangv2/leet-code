# Write your MySQL query statement below

select Score, (select count(*) from
                (select distinct Score s from Scores) temp
                where s >= Score)
              as Rank
from Scores
ORDER BY Score desc;