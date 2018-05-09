# Write your MySQL query statement below
select round(sqrt( min( pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2) ) ), 2) as shortest from point_2d as p1, point_2d as p2
where p1.x <> p2.x or p1.y <> p2.y;