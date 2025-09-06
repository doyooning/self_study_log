#12세 이하인 여자 환자 목록 출력하기
SELECT pt_name, pt_no, gend_cd, age, ifnull(tlno, 'NONE') as tlno
from patient
where age <= 12 and gend_cd like 'W'
order by age desc, pt_name asc;