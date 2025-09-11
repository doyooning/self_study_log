# 강원도에 위치한 생산공장 목록 출력하기
SELECT factory_id, factory_name, address
from food_factory
where left(address, 3) = '강원도'
order by factory_id asc;