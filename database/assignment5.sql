-- Question 1: tạo view có chứa danh sách nhanh viên thuộc phòng ban "sale"
CREATE OR REPLACE VIEW view_01 AS
SELECT *
FROM account
WHERE department_id = 
		(SELECT department_id
        FROM department
        WHERE department_name = "Sale");
-- Question 2: tạo view có chứa thông tin các account tham gia vào nhiều group nhất.
SELECT account.*
FROM group_account
RIGHT JOIN account USING (account_id)
GROUP BY account_id
HAVING COUNT(group_id) = (
    SELECT MAX(group_count)
    FROM (
        SELECT COUNT(group_id) AS group_count
        FROM group_account
        RIGHT JOIN account USING (account_id)
        GROUP BY account_id
    ) AS t);
-- Question 3 : Tạo view có chứa câuu hỏi có những content quá dài( content quá 300 từ
-- là quá dài) và xoá nó đi 
CREATE OR REPLACE VIEW view_03 AS
SELECT *
FROM question
WHERE CHAR_LENGTH(content) >10;
DELETE FROM view_03;
-- Question 4: tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
SELECT department.*
FROM account
RIGHT JOIN department USING (department_id)
GROUP BY department_id
HAVING COUNT(account_id) =
		(SELECT MAX( account_count)
        FROM (SELECT COUNT(account_id) AS account_count
        FROM account
        RIGHT JOIN department USING (department_id)
        GROUP BY department_id) AS t);
-- thực hành về CTE
CREATE OR REPLACE VIEW view_04 AS
WITH c4 AS (
SELECT department.* , COUNT(account_id) AS account_count
FROM account
RIGHT JOIN department USING (department_id)
GROUP By department_id
)
SELECT *
FROM c4
WHERE account_count =
	(SELECT MAX(account_count)
    FROM c4);
	