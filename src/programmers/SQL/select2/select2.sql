select f.flavor
from first_half f, icecream_info i
where f.flavor = i.flavor
  and total_order > 3000 and i.ingredient_type like 'fruit_based'