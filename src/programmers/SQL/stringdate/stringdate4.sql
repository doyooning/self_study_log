# 자동차 평균 대여 기간 구하기
SELECT car_id,
       round(avg(datediff(end_date, start_date) + 1), 1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having AVERAGE_DURATION >= 7
order by AVERAGE_DURATION desc, car_id desc;
/*
 datediff(end_date, start_date) -> 기간 구할 때 +1 해주기
 ex) end_date = start_date면 기간이 하루니까 1이 나와야 함

 where 절에는 집계 함수를 사용 못 한다
 해야될 것 같을 땐 group by - having 절이다
*/