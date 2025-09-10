# 특정 물고기를 잡은 총 수 구하기
select count(fish_type) as fish_count
from fish_info
where fish_type = (
    select i.fish_type
    from fish_name_info i
    where fish_name = 'BASS'
) or fish_type = (
    select i.fish_type
    from fish_name_info i
    where fish_name = 'SNAPPER'
);

-- fish_type 이 0인 속성 + 1인 속성