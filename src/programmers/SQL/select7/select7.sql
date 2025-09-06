# 재구매가 일어난 상품과 회원 리스트 구하기
SELECT user_id, product_id
from online_sale
group by user_id, product_id -- group by도 당연히 2개 이상 속성에 대해 적용할 수 있다
having count(*) >= 2 -- * -> 그룹 속성 전체
order by user_id asc, product_id desc;