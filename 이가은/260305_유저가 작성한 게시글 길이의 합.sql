SELECT
	user_id,
	SUM(LENGTH(contents)) as total
FROM blog_posts
GROUP BY user_id
ORDER BY total DESC