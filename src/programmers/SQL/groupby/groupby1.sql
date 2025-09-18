# 진료과별 총 예약 횟수 출력하기
SELECT MCDP_CD as '진료과코드', count(*) as '5월예약건수'
from appointment
where date_format(apnt_ymd, '%Y-%m') = '2022-05'
group by mcdp_cd
order by count(apnt_no) asc, mcdp_cd asc;