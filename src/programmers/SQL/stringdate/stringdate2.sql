# 특정 옵션이 포함된 자동차 리스트 구하기
SELECT car_id, car_type, daily_fee, options
from CAR_RENTAL_COMPANY_CAR
where options like '%네비게이션%'
order by car_id desc;