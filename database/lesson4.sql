-- Mệnh đề JOIN : Kếp hợp bảng
-- INNER JOIN
-- VD : lấy ra nhâ viên thuộc @hòng ban " Giám Đốc"
SELECT account.*
FROM account
INNER JOIN department 
ON account.department_id = department.department_id
WHERE department_name = "Giám đốc";
-- từ khoá USING
-- dùng để viết ngắn gọn lại điều kiện
-- VD : lấy ra nhâ viên thuộc @hòng ban " Giám Đốc"
SELECT *
FROM account
INNER JOIN department USING(department_id)
WHERE department_name = "Giám đốc";

-- LEFT / RIGHT JOIN
-- VD : lấy ra tất cả các phòng ban và thông tin nhân viên trong phòng ban đó

SELECT department.*, COUNT(account_id)
FROM account
RIGHT JOIN department USING (department_id)
GROUP BY department_id;

-- LEFT / RIGHT EXCLUDING JOIN
-- VD : Lấy ra phòng ban không có người 
SELECT department .*
FROM department
LEFT JOIN account USING (department_id)
WHERE account_id IS NULL;

-- CROSS JOIN
-- VD : 
SELECT *
FROM department
CROSS JOIN position;

-- UNION / UNION ALL
-- VD: lấy ra phòng ban hoặc chức vụ có chứa lí tự "d"
SELECT department_id AS id, department_name AS name
FROM department
WHERE department_name LIKE "%d%"
UNION
SELECT position_id AS id, position_name AS name
FROM position
WHERE position_name LIKE "%d%";
-- INTERSECT : giao 1 tập hợp
SELECT 1 AS month,
INTERSECT
SELECT 1 AS month;

-- EXCEPT : trừ 2 tập hợp
SELECT 1 AS month
EXCEPT
SELECT 2 AS month;

