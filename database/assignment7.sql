DROP DATABASE IF EXISTS assignment_07;
CREATE DATABASE assignment_07;
USE assignment_07;

-- Tạo bảng department
DROP TABLE IF EXISTS department;
CREATE TABLE department (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(50)
);

-- Tạo bảng position
DROP TABLE IF EXISTS position;
CREATE TABLE position (
    position_id INT PRIMARY KEY AUTO_INCREMENT,
    position_name ENUM("Dev", "Test", "Scrum Master", "PM")
);

-- Tạo bảng account
DROP TABLE IF EXISTS account;
CREATE TABLE account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50),
    username VARCHAR(50) UNIQUE NOT NULL,
    full_name VARCHAR(50),
    department_id INT,
    position_id INT,
    create_date DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (department_id)
        REFERENCES department (department_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (position_id)
        REFERENCES position (position_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
    group_id INT PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(50),
    creator_id INT,
    create_date DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (creator_id)
        REFERENCES account (account_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng group_account
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account (
    group_id INT,
    account_id INT,
    join_date DATE DEFAULT (CURRENT_DATE),
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id)
        REFERENCES `group` (group_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (account_id)
        REFERENCES account (account_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng type_question
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
    type_id INT PRIMARY KEY AUTO_INCREMENT,
    type_name ENUM("Essay", "Multiple-Choice")
);

-- Tạo bảng category_question
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50)
);

-- Tạo bảng question
DROP TABLE IF EXISTS question;
CREATE TABLE question (
    question_id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(50),
    category_id INT,
    type_id INT,
    creator_id INT,
    create_date DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (category_id)
        REFERENCES category_question (category_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (type_id)
        REFERENCES type_question (type_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (creator_id)
        REFERENCES account (account_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng answer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
    answer_id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(50),
    question_id INT,
    is_correct BOOLEAN,
    FOREIGN KEY (question_id)
        REFERENCES question (question_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam (
    exam_id INT PRIMARY KEY AUTO_INCREMENT,
    code CHAR(10),
    title VARCHAR(50),
    category_id INT,
    duration INT,
    creator_id INT,
    create_date DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (category_id)
        REFERENCES category_question (category_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (creator_id)
        REFERENCES account (account_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Tạo bảng exam_question
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question (
    exam_id INT,
    question_id INT,
    PRIMARY KEY (exam_id, question_id),
    FOREIGN KEY (exam_id)
        REFERENCES exam (exam_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (question_id)
        REFERENCES question (question_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- Thêm dữ liệu cho bảng department
INSERT INTO department  (department_name)
VALUES                  ("Marketing"    ),
                        ("Sale"         ),
                        ("Bảo vệ"       ),
                        ("Nhân sự"      ),
                        ("Kỹ thuật"     ),
                        ("Tài chính"    ),
                        ("Phó giám đốc" ),
                        ("Giám đốc"     ),
                        ("Thư kí"       ),
                        ("Bán hàng"     ); 

-- Thêm dữ liệu cho bảng position
INSERT INTO position    (position_name )
VALUES                  ("Dev"         ),
                        ("Test"        ),
                        ("Scrum Master"),
                        ("PM"          );

-- Thêm dữ liệu cho bảng account
INSERT INTO account (email                           , username      , full_name           , department_id, position_id, create_date )
VALUES              ("haidang29productions@gmail.com", "dangblack"   , "Nguyen Hai Dang"   , 1            , 1          , "2019-01-15"),
                    ("account1@gmail.com"            , "quanganh"    , "Tong Quang Anh"    , 1            , 2          , "2020-02-25"),
                    ("account2@gmail.com"            , "vanchien"    , "Nguyen Van Chien"  , 1            , 3          , "2021-03-17"),
                    ("account3@gmail.com"            , "cocoduongqua", "Duong Do"          , 3            , 4          , "2022-03-08"),
                    ("account4@gmail.com"            , "doccocaubai" , "Nguyen Chien Thang", 4            , 4          , "2015-03-20"),
                    ("dapphatchetngay@gmail.com"     , "khabanh"     , "Ngo Ba Kha"        , 6            , 3          , "2016-04-05"),
                    ("songcodaoly@gmail.com"         , "huanhoahong" , "Bui Xuan Huan"     , 2            , 2          , "2017-04-14"),
                    ("sontungmtp@gmail.com"          , "tungnui"     , "Nguyen Thanh Tung" , 8            , 1          , "2018-04-18"),
                    ("duongghuu@gmail.com"           , "duongghuu"   , "Duong Van Huu"     , 9            , 2          , "2023-04-07"),
                    ("vtiaccademy@gmail.com"         , "vtiaccademy" , "Vi Ti Ai"          , 2            , 1          , "2024-04-29");

-- Thêm dữ liệu cho bảng group
INSERT INTO `group` (group_name        , creator_id, create_date )
VALUES              ("Testing System"  , 1         , "2019-03-15"),
                    ("Developement"    , 1         , "2020-03-27"),
                    ("VTI Sale 01"     , 2         , "2021-03-09"),
                    ("VTI Sale 02"     , 3         , "2022-01-10"),
                    ("VTI Sale 03"     , 3         , "2023-08-28"),
                    ("VTI Creator"     , 6         , "2024-08-06"),
                    ("VTI Marketing 01", 3         , "2024-10-17"),
                    ("Management"      , 8         , "2020-11-28"),
                    ("Chat with love"  , 9         , "2022-11-09"),
                    ("Vi Ti Ai"        , 3         , "2022-12-10");

-- Thêm dữ liệu cho bảng group_account
INSERT INTO group_account   (group_id, account_id, join_date   )
VALUES                      (1       , 1         , "2019-03-05"),
                            (2       , 1         , "2020-11-17"),
                            (3       , 1         , "2021-09-29"),
                            (4       , 1         , "2022-12-10"),
                            (5       , 5         , "2022-04-28"),
                            (2       , 6         , "2023-08-26"),
                            (7       , 2         , "2024-02-07"),
                            (3       , 8         , "2020-05-18"),
                            (2       , 2         , "2020-02-04"),
                            (10      , 10        , "2020-12-10");

-- Thêm dữ liệu cho bảng type_question
INSERT INTO type_question (type_name)
VALUES ("Essay"), ("Multiple-Choice"); 

-- Thêm dữ liệu cho bảng category_question
INSERT INTO category_question   (category_name)
VALUES                          ("Java"       ),
                                ("ASP.NET"    ),
                                ("ADO.NET"    ),
                                ("SQL"        ),
                                ("Postman"    ),
                                ("Ruby"       ),
                                ("Python"     ),
                                ("C++"        ),
                                ("C Sharp"    ),
                                ("PHP"        ); 

-- Thêm dữ liệu cho bảng question
INSERT INTO question    (content          , category_id, type_id, creator_id, create_date )
VALUES                  ("Câu hỏi về Java", 1          , 1      , 1         , "2020-04-05"),
                        ("Câu Hỏi về PHP" , 1          , 2      , 2         , "2020-04-05"),
                        ("Hỏi về C#"      , 9          , 2      , 5         , "2020-04-06"),
                        ("Hỏi về Ruby"    , 6          , 1      , 5         , "2020-04-06"),
                        ("Hỏi về Postman" , 5          , 1      , 5         , "2020-04-06"),
                        ("Hỏi về ADO.NET" , 5          , 2      , 6         , "2020-04-06"),
                        ("Hỏi về ASP.NET" , 5          , 1      , 1         , "2020-04-06"),
                        ("Hỏi về C++"     , 5          , 1      , 8         , "2020-04-07"),
                        ("Hỏi về SQL"     , 4          , 2      , 3         , "2020-04-07"),
                        ("Hỏi về Python"  , 7          , 1      , 10        , "2020-04-07");

-- Thêm dữ liệu cho bảng answer
INSERT INTO answer  (content     , question_id, is_correct)
VALUES              ("Trả lời 01", 1          , 0         ),
                    ("Trả lời 02", 1          , 1         ),
                    ("Trả lời 03", 1          , 0         ),
                    ("Trả lời 04", 1          , 1         ),
                    ("Trả lời 05", 2          , 1         ),
                    ("Trả lời 06", 3          , 1         ),
                    ("Trả lời 07", 4          , 0         ),
                    ("Trả lời 08", 8          , 0         ),
                    ("Trả lời 09", 9          , 1         ),
                    ("Trả lời 10", 10         , 1         );

-- Thêm dữ liệu cho bảng exam
INSERT INTO exam    (code     , title           , category_id, duration, creator_id, create_date )
VALUES              ("VTIQ001", "Đề thi C#"     , 1          , 60      , 1         , "2019-04-05"),
                    ("VTIQ002", "Đề thi PHP"    , 1          , 60      , 1         , "2019-04-05"),
                    ("VTIQ003", "Đề thi C++"    , 9          , 120     , 2         , "2019-04-07"),
                    ("VTIQ004", "Đề thi Java"   , 2          , 60      , 3         , "2020-04-08"),
                    ("VTIQ005", "Đề thi Ruby"   , 2          , 120     , 4         , "2020-04-10"),
                    ("VTIQ006", "Đề thi Postman", 2          , 60      , 6         , "2020-04-05"),
                    ("VTIQ007", "Đề thi SQL"    , 2          , 60      , 1         , "2020-04-05"),
                    ("VTIQ008", "Đề thi Python" , 8          , 60      , 8         , "2020-04-07"),
                    ("VTIQ009", "Đề thi ADO.NET", 4          , 90      , 3         , "2020-04-07"),
                    ("VTIQ010", "Đề thi ASP.NET", 7          , 90      , 1         , "2020-04-08");

-- Thêm dữ liệu cho bảng exam_question
INSERT INTO exam_question   (question_id, exam_id)
VALUES                      (1         , 1      ),
                            (2         , 2      ),
                            (3         , 1      ),
                            (4         , 4      ),
                            (5         , 1      ),
                            (6         , 2      ),
                            (7         , 1      ),
                            (8         , 8      ),
                            (9         , 2      ),
                            (10        , 10     );
-- Question 1: Tạo trigger không cho phép người dùng
-- nhập vào group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS trigger_01;
DELIMITER $$
CREATE TRIGGER trigger_01
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
    IF NEW.create_date < CURRENT_DATE - INTERVAL 1 YEAR THEN
        SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = "Không cho phép tạo group có ngày tạo trước 1 năm trước";
    END IF;
END $$
DELIMITER ;

INSERT INTO `group` (group_id, group_name, creator_id, create_date)
VALUES (11, "MySQL", 1, "2020-01-01");
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
-- "Sale" cannot add more user"
DROP TRIGGER IF EXISTS trigger_02;
DELIMITER $$
CREATE TRIGGER trigger_02
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
	DECLARE v_sale_id INT;
    SELECT department_id INTO v_sale_id
    FROM department
    WHERE department_name = "Sale";
	IF NEW.department_id = v_sale_id THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "department sale cannot add more user";
    END IF;
END $$
DELIMITER ;
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 account
DROP TRIGGER IF EXISTS trigger_03;
DELIMITER $$
CREATE TRIGGER trigger_03
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
	DECLARE v_account_count INT;
    
    SELECT COUNT(account_id) INTO v_account_count 
    FROM group_account
    WHERE group_id = NEW.group_id;
    IF NEW.group_id >= 5 THEN
    SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = "Không thể thêm account vào group này";
    END IF;
END $$
DELIMITER ;

-- giải
DROP TRIGGER IF EXISTS trigger_03;
DELIMITER $$
CREATE TRIGGER trigger_03
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
    DECLARE v_account_count INT;
    
    SELECT COUNT(account_id) INTO v_account_count
    FROM group_account
    WHERE group_id = NEW.group_id;

    IF v_account_count >= 5 THEN
        SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = "Mỗi group có tối đa 5 người";
    END IF;
END $$
DELIMITER ;

INSERT INTO group_account (account_id, group_id, join_date)
VALUES (1, 10, "2020-01-01");


-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 question
DROP TRIGGER IF EXISTS trigger_04;
DELIMITER $$
CREATE TRIGGER trigger_04
BEFORE INSERT ON exam_question
FOR EACH ROW
BEGIN
	DECLARE v_question_count INT;
    
    SELECT COUNT(question_id) INTO  v_question_count
    FROM exam_question
    WHERE exam_id= NEW.question_id;
    IF v_question_count >= 10 THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = " Không thể thêm câu hỏi vào đề thi này nữa";
	END IF;

END $$
DELIMITER ;
INSERT INTO exam_question (exam_id, question_id) 
VALUES ('1', '11');
-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com 
DROP TRIGGER IF EXISTS trigger_05;
DELIMITER $$
CREATE TRIGGER trigger_05
BEFORE DELETE ON account
FOR EACH ROW
BEGIN
	
    IF OLD.email = "admin@gmail.com" THEN
		 SIGNAL SQLSTATE "4500"
         SET MESSAGE_TEXT = " không được xoá tài khoản này";
	END IF;

END $$
DELIMITER ;
-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS trigger_06;
DELIMITER $$
CREATE TRIGGER trigger_06
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
	DECLARE v_waiting_id INT;
    
    IF NEW.department_id IS NULL THEN
		SELECT department_id INTO v_waiting_id
		FROM department
		WHERE department_name = "phòng chờ";
		 SET NEW.department_id = v_waiting_id;
	END IF;

END $$
DELIMITER ;
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.
-- gợi ý: viết trigger cho câu trả lời, dùng bảng answer, đếm câu trả lời, >= 4 -> không cho phép trả lời nữa.
-- correct_answer_count >= 2
DROP TRIGGER IF EXISTS trigger_07;
DELIMITER $$
CREATE TRIGGER trigger_07
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
	DECLARE v_answer_count INT;
    DECLARE v_correct_answer_count INT;
    
    SELECT COUNT(answer_id) INTO  v_answer_count
    FROM answer
    WHERE question_id = NEW.question_id;
    
    IF v_anwer_count >= 4 THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = " Không thể thêm câu trả lời vào đề thi này nữa";
	END IF;
    SELECT COUNT(answer_id) INTO  v_correct_answer_count
    FROM answer
    WHERE question_id = NEW.question_id AND is_correct = 1;
    IF v_correct_anwer_count >= 2 AND NEW.is_correct = TRUE THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = " Một câu hỏi có tối đa 2 câu trả lời đúng";
	END IF;

END $$
DELIMITER ;
-- Question 9: viết trigger không cho phép người dùng xoá bài thi mới tạo trong 2 ngày
-- create day >= t -2
DROP TRIGGER IF EXISTS trigger_09;
DELIMITER $$
CREATE TRIGGER trigger_09
BEFORE DELETE ON exam
FOR EACH ROW
BEGIN
	
	IF OLD.create_date >= DATE_SUB(CURRENT_DATE, INTERVAL 2 DAY) THEN
    -- hoặc là IF OLD.create_date >= CURRENT_DATE - INTERVAL 2 DAY THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "bài thi mới làm không được xoá";
    END IF;
END $$
DELIMITER ;
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
-- gợi ý : dùng bảng exam_question
DROP TRIGGER IF EXISTS trigger_update_10;
DELIMITER $$
CREATE TRIGGER trigger_update_10
BEFORE UPDATE ON question
FOR EACH ROW
BEGIN
	DECLARE v_exam_count INT;
    
	SELECT COUNT(exam_id) INTO v_exam_count
    FROM exam_question
    WHERE question_id = OLD.question_id;
    
    IF v_exam_count > 0  THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = " Không được phép cập nhật ";
	END IF;

END $$
DELIMITER ;
DROP TRIGGER IF EXISTS trigger_delete_10;
DELIMITER $$
CREATE TRIGGER trigger_delete_10
BEFORE DELETE ON question
FOR EACH ROW
BEGIN
	DECLARE v_exam_count INT;
    
	SELECT COUNT(exam_id) INTO v_exam_count
    FROM exam_question
    WHERE question_id = OLD.question_id;
    
    IF v_exam_count > 0  THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = " Không được phép xoá ";
	END IF;

END $$
DELIMITER ;
-- Question 12: Lấy ra thông tin exam trong đó : Duration <= 30 thì sẽ đổi giá thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổo thành giá trị "Long time"

SELECT *,
	CASE
		WHEN Duration <= 30 THEN "Short time"
        WHEN Duration <= 60 THEN "Long Time"
        ELSE "Long time"
    END AS duration_time
FROM exam;
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

WITH c1 AS(
SELECT group_id, COUNT(account_id) AS account_count
FROM group_account
RIGHT JOIN `group` USING(group_id)
GROUP BY group_id)
SELECT *,
	CASE
		WHEN account_count <= 5 THEN "few"
        WHEN account_count <= 20 THEN "normal "
        ELSE "higher"
    END AS the_number_user_amount
FROM c1;
-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

WITH c2 AS(
	SELECT department_id, COUNT(account_id) AS account_count
    FROM department
    LEFT JOIN account USING (department_id)
    GROUP BY department_id
)
SELECT *,
	CASE
		WHEN account_count = 0 THEN "không có User"
        ELSE account_count 
    END AS Count
FROM c2;
-- chuẩn khoá 1: không nên dùng thêm cột nếu có thể tính toán ra. 

