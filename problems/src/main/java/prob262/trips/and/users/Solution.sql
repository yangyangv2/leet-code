# Write your MySQL query statement below

select Request_at as Day,
 Round( count(if( Status !='completed', TRUE, NULL)) / count(*), 2) as 'Cancellation Rate'
from Trips
where Client_Id  in
(select Users_Id from Users where Banned = 'No' and Role = 'client')
and Request_at between '2013-10-01' and '2013-10-03'
group by Request_at;