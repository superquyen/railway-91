-- Mệnh đề SELECT
-- VD: Lấy ra ngày hôm nay
SELECT CURRENT_DATE;
-- VD: Lấy ra PI, 1 + 2
SELECT PI(), 1 + 2;
-- VD: Alias
SELECT "MySQL" AS "Database";

-- Mệnh đề FROM
-- VD: Lấy ra tất cả mã đề thi
SELECT code
FROM exam;
-- VD: Lấy ra tất cả câu hỏi
SELECT *
FROM question;
-- VD: Lấy ra tất cả thời gian thi (không trùng nhau)
SELECT DISTINCT duration
FROM exam;

-- Mệnh đề WHERE
-- Toán tử: >, >=, <, <=, =, != (<>)
-- VD: Lấy ra account có id > 5
SELECT *
FROM account
WHERE account_id > 5;
-- Toán tử: AND, OR
-- VD: Lấy ra account có department_id = 1 và position_id = 1
SELECT *
FROM account
WHERE department_id = 1 AND position_id = 1;
-- VD: Lấy ra account có department_id = 1 hoặc position_id = 1
SELECT *
FROM account
WHERE department_id = 1 OR position_id = 1;
-- Toán tử BETWEEN ... AND ...
-- VD: Lấy ra department có 5 <= id <= 8
SELECT *
FROM department
WHERE department_id BETWEEN 5 AND 8;
-- Toán tử IN / NOT IN
-- VD:  lấy ra department có id = any(2,4,6,8)
SELECT *
FROM department
WHERE department_id IN (2, 4, 6, 8);
-- Toán tử LIKE / NOT LIKE
-- _: đại diện cho 1 ký tự bất kì
-- %: đại diện cho 0 hoặc nhiều kí tự bất kì
-- VD ; Lấy ra phòng có tên chứa lí tự "n"
SELECT *
FROM department
WHERE department_name LIKE "%n%";
-- Toán tử IS NULL / IS NOT NULL
-- VD: lấy ra department có tên
SELECT *
FROM department
WHERE department_name IS NOT NULL; 

-- mệnh đề ORDER BY
-- ASC: tăng dần (Mặc định)
-- DESC: giảm dần
-- VD:　lấy ra exam sắp xếp duration giảm dần
SELECT *
FROM exam
ORDER BY duration DESC, create_date ASC;

-- mệnh đề LIMIT
-- VD : lấy ra 2 đề thi
SELECT *
FROM exam
LIMIT 9;

-- các hàm tổng hợPREPARE
-- COUNT: đếm, SUM : tổng, MIN : thấp nhất ; MAX : cao nhất, AVG : gtri trung bình
-- COUNT(*) Đếm số dòng
-- COUNT(duration) : đếm số dòng có duration khác NULL
-- COUNT(DISTINCT duration) : đếm số dòng có duration khác nhau
-- Chú ý : chỉ áp dụng cho các gía trị khác NULL
-- VD : lấy ra số lượng phòng ban 

SELECT COUNT(*)
FROM department;

SELECT 
	COUNT(*),
    COUNT(duration),
    COUNT(DISTINCT duration),
    SUM(duration),
    MIN(duration),
    MAX(duration),
    AVG(duration)
FROM exam;

-- Mệnh đề GROUP BY
-- VD: Thống kê số nhân viên trong từng phòng ban
SELECT department_id, COUNT(account_id) AS account_count
FROM account
GROUP BY department_id;

--  mệnh đề HAVING : điều kiện trên một tập thể, một nhóm
-- VD: LẤY RA PHÒNG BAN CÓ > 2 NHÂN VIÊN
SELECT department_id, count(account_id) AS account_count
FROM account
GROUP BY  department_id
HAVING COUNT(account_id) > 2;

-- cập nhật
-- VD : đổi tên phòng ban số 1 thành "phòng chờ"
UPDATE department
SET department_name = "Phòng chờ"
WHERE department_id = 1;

-- xoá dữ liệu
-- VD : xoá phòng ban số 1
DELETE FROM department
WHERE department_id = 1;



