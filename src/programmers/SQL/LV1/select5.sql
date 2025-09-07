# 인기있는 아이스크림
SELECT flavor
from first_half
order by total_order desc, shipment_id asc;