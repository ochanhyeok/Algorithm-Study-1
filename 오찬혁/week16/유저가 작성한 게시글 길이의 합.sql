select user_id, sum(length(contents)) as total
from blog_posts
group by user_id
order by total desc, user_id desc;