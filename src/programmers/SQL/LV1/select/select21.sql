# 가장 큰 물고기 10마리 구하기
select id, length
from fish_info
order by length desc, id asc limit 10;