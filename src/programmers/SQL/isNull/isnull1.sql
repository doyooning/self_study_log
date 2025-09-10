# 경기도에 위치한 식품창고 목록 출력하기
select warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') as freezer_yn
from food_warehouse
where address like '%경기도%'
order by warehouse_id;

/* case when 사용
select warehouse_id, warehouse_name, address, case
    when freezer_yn is null then 'N'
    else freezer_yn end as freezer_yn
from food_warehouse
where address like '%경기도%'
order by warehouse_id;
*/