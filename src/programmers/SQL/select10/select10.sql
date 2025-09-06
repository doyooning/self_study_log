# 어린 동물 찾기
SELECT animal_id, name
from animal_ins
where intake_condition not like 'Aged'
order by animal_id;