SELECT id, created_at, category, amount, merchant_id
FROM card_usages 
WHERE amount >= 50000
   AND category = 0
ORDER BY id;