# 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT dr_name, dr_id, mcdp_cd, date_format(hire_ymd, '%Y-%m-%d') as hire_ym
from doctor
where mcdp_cd in ('cs', 'gs')
order by hire_ymd desc, dr_name asc;
