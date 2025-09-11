# 업그레이드 된 아이템 구하기
select i.item_id, i.item_name, i.rarity
from item_info i
join item_tree t on i.item_id = t.item_id
where t.parent_item_id in ( -- 뽑힌 id 중에 parent_item_id가 있으면
    select item_id
    from item_info
    where rarity = 'RARE' -- item_info에서 RARE인 id만 뽑기
)
order by item_id desc;