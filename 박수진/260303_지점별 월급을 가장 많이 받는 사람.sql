SELECT e.branch_id, e.name
FROM employees e
JOIN (
  SELECT branch_id, MAX(salary) AS max_salary
  FROM employees
  GROUP BY branch_id
) m
  ON e.branch_id = m.branch_id AND e.salary = m.max_salary
ORDER BY e.branch_id, e.name;