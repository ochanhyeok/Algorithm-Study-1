SELECT branch_id, name
FROM employees
WHERE (branch_id, salary) IN (
    SELECT branch_id, MAX(salary)
    FROM employees
    GROUP BY branch_id
)
ORDER BY branch_id, name;
