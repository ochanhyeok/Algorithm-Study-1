SELECT 
	t.branch_id, employees.name
FROM employees
JOIN (
	SELECT
		branch_id, MAX(salary) as max_salary
	FROM employees
	GROUP BY branch_id
) t
ON employees.branch_id = t.branch_id
WHERE employees.salary = t.max_salary
ORDER BY t.branch_id, employees.name