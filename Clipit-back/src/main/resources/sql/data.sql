select count(*) as count, pbp.body_part as bodyPart, vp.user_id as user
from visited_post vp
         left join post on vp.post_id = post.id
         left join post_body_part pbp on post.id = pbp.post_id
group by bodyPart, vp.user_id
having user = 'admin';