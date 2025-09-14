# 물고기 종류 별 대어 찾기
select i.id, n.fish_name, i.length
from fish_info i
     join fish_name_info n on i.fish_type = n.fish_type
where (n.fish_type, i.length) in ( -- in을 사용해서 결과값 맞춰주기
      select fish_type, max(length)
      from fish_info                -- 종류 별 대어의 목록
      group by fish_type
)
order by i.id;