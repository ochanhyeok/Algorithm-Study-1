SELECT e.branch_id, e.name
FROM employees e
JOIN (
	SELECT branch_id, MAX(salary) AS max
	FROM employees 
	GROUP BY branch_id
) m  ON e.branch_id = m.branch_id
	AND e.salary = m.max
ORDER BY e.branch_id, e.name 