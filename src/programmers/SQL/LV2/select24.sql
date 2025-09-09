# 조건에 맞는 개발자 찾기
select id, email, first_name, last_name
from developers
where skill_code & (
    select code
    from skillcodes
    where name = 'C#'
) > 0 or skill_code & (
    select code
    from skillcodes
    where name = 'Python'
) > 0
order by id asc;