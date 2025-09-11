# 부모의 형질을 모두 가지는 대장균 찾기
select e.id, e.genotype, p.genotype as parent_genotype
from ecoli_data e
    join ecoli_data p on e.parent_id = p.id
where (e.genotype & p.genotype) = p.genotype
order by e.id asc;

-- self-join 패턴 - 부모-자식 처럼 상위-하위 관계 형성시 사용
-- 메인으로 쓸 테이블을 e, 셀프조인할 테이블을 p로 하고
    -- e : 자식, p : 부모
-- 메인의 parent_id를 서브의 id와 연결
