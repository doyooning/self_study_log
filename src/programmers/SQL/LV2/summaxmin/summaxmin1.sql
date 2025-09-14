# 가격이 제일 비싼 식품의 정보 출력하기
select product_id, product_name, product_cd, category, price
from food_product
order by price desc limit 1;