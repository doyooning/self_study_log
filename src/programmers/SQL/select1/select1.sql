select title, A.board_id, B.reply_id, B.writer_id, B.contents, date_format(b.created_date, '%Y-%m-%d') as created_date
from used_goods_board as A
         join used_goods_reply as B
              on A.board_id = B.board_id
where year(A.created_date) = 2022 and month(A.created_date) = 10
order by created_date, title