# 잡은 물고기의 평균 길이 구하기
select round(avg(ifnull(length, 10)), 2) as average_length
from fish_info;