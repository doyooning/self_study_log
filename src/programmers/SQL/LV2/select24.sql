# 조건에 맞는 개발자 찾기
select distinct d.id, d.email, d.first_name, d.last_name
from developers d, skillcodes s
where (256 & d.skill_code) > 0 or (1024 & d.skill_code) > 0
order by d.id asc;