# 잔챙이 잡은 수 구하기
select count(id) as fish_count
from fish_info
where length is null;
