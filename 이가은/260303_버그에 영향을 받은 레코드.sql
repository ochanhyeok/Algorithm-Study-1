SELECT coupons.cart_id, SUM(cp.price) < minimum_requirement AS abused
FROM coupons
JOIN cart_products cp
	ON coupons.cart_id = cp.cart_id 
GROUP BY coupons.cart_id