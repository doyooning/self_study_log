# 업그레이드 할 수 없는 아이템 구하기
select i.item_id, i.item_name, i.rarity
from item_info i
where item_id not in (
    select distinct i.item_id
    from item_tree t
    join item_info i
        on t.parent_item_id = i.item_id
)
order by i.item_id desc;