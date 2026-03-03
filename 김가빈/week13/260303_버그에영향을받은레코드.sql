SELECT 
	p.cart_id, 
	CASE 
			WHEN p.total < c.minimum_requirement THEN 1 
			ELSE 0
	END AS abused
FROM (
	SELECT 
		cart_id,
		SUM(price) AS total
	FROM cart_products  
	GROUP BY cart_id
) p
LEFT JOIN coupons c ON p.cart_id=c.cart_id
ORDER BY p.cart_id