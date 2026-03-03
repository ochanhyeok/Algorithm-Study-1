SELECT 
  c.cart_id,
  CASE
    WHEN SUM(cp.price) < c.minimum_requirement THEN 1
    ELSE 0
  END AS abused
FROM coupons c JOIN cart_products cp
  ON c.cart_id = cp.cart_id
GROUP BY cart_id, c.minimum_requirement
ORDER BY cart_id;