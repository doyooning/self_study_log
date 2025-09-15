# 한 해에 잡은 물고기 수 구하기
select count(id) as fish_count
from fish_info
where year(time) = '2021';