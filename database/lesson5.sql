-- SUBQYERY : truy van con
-- VD:  lấy ra nhân viên thuộc phòng ban giám đốc
SELECT *
FROM account
WHERE department_id = (
	SELECT department_id
	FROM department
	WHERE department_name = "Giám đốc");
-- Toán tử : IN, ANY, ALL, EXISTS
-- VD : Lấy ra phòng ban có người mang họ "Nguyễn"
SELECT *
FROM department
WHERE department_id IN (
	SELECT  department_id 
	FROM account
	WHERE full_name LIKE "nguyen%");
    

SELECT *
FROM account;
SELECT *
FROM department
WHERE department_id = ANY
		(SELECT DISTINCE department_id)
-- VD : lấy ra câu hỏi có nhiều câu trả lời nhất
-- B1 : Thống kê mỗi câu hỏi có bao nhiêu câu trả lời
SELECT  COUNT(answer_id) AS answer_count
FROM answer
RIGHT JOIN question USING (question_id)
GROUP BY question_id;


-- B2 : lấy ra số lớn nhất : 17
SELECT MAX (answer_count)
FROM (SELECT  COUNT(answer_id) AS answer_count
FROM answer
RIGHT JOIN question USING (question_id)
GROUP BY question_id) AS t;

-- B3 : lấy ra câu hỏi có số câu trả lời = 17 (B2)
SELECT question.*
FROM answer
RIGHT JOIN question USING (question_id)
GROUP BY question_id
HAVING COUNT(answer_id) = 
		(SELECT MAX (answer_count)
        
		FROM 
        (SELECT  COUNT(answer_id) AS answer_count
		FROM answer
		RIGHT JOIN question USING (question_id)
		GROUP BY question_id) AS t);
        
-- VIEW : bảng ảo, nội dung được xác định thông qua 1 truy vấn. không chứa dữ liệu trên database.
-- khi thay đổi dữ liệu bảng liên quan tới view thì sẽ được trả về 
-- mới nhất. nên để lấy dữ liệu chứ không nên thay đổi dữ liệu, không sử dụng insert, update, delete, chỉ nên dùng SELECT thôi
DROP VIEW IF EXISTS view_01;

CREATE OR REPLACE VIEW view_01 AS
SELECT *
FROM department;

-- sử dụng view
SELECT *
FROM view_01;
-- CTE : bảng tạm, tồn tại khi chạy truy vấn thôi. sử dụng lúc tái sử dụng 
-- with < tên tờ nháp > AS ()
-- ví dụ lấy ra câu hỏi có nhiều câu trả lời nhất 
WITH c1 AS (
    SELECT question.*, COUNT(answer_id) AS answer_count
    FROM answer
    RIGHT JOIN question USING (question_id)
    GROUP BY question_id
)
SELECT *
FROM c1
WHERE answer_count =
    (SELECT MAX(answer_count)
    FROM c1);