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

-- & 비트 연산자 -> (큰 수) & (작은 수) 했을 때
-- 결과가 0 => 정확히 일치, 두 수가 같음
-- 결과가 > 0 => 큰 수에 작은 수가 포함됨
-- 결과가 = 0 => 포함 안 됨