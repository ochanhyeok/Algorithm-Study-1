SELECT 
  user_id,
  SUM(CHAR_LENGTH(contents)) AS total
FROM blog_posts
GROUP BY user_id
ORDER BY total DESC, user_id DESC;