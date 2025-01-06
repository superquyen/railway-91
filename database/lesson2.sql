DROP DATABASE IF EXISTS lesson_02;
CREATE DATABASE lesson_02;
USE lesson_02;

DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id INT,
    department_name VARCHAR(50)
);
-- them du lieu vao bang
INSERT INTO department(department_id, department_name)
VALUES (1, "Giam doc"), 
	   (2, "bao ve");
	
-- hien thi du lieu
TABLE department;
-- rang buoc du lieu (Constraints)

-- null/ not null
DROP TABLE IF EXISTS student;
CREATE TABLE student(
	email VARCHAR(50) NOT NULL
    
);
-- VD them studen co email la null
INSERT INTO student (email) VALUES ("superequyen@gmail.com");

-- UNIQUE KEY : duy nhat
DROP TABLE IF EXISTS customer;
CREATE TABLE customer(
	phone CHAR(10) UNIQUE NOT NULL
    
);
-- VD them studen co email la null
INSERT INTO customer (phone) 
VALUES ("0987654321"),
	   ("0987654322");
-- default : mac dich
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
	is_correct BOOLEAN DEFAULT FALSE,
    create_date DATE DEFAULT (current_date)
    
);

INSERT INTO answer (is_correct) 
VALUES (false);
TABLE answer;

-- check : kiem tra
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	age INT CHECK (age >= 18)
    
);
INSERT INTO `account` (age) VALUES (20);
-- PRIMARY key : khoa chinh
-- yeu cau : UNIQUE + NOT NULL
-- 1. mot bang co toi da mot khoa chinh
-- 2. mot khoa chinh co mot hoac nhieu cot
-- AUTO_INCREMENT
-- VD: khoa chinh mot cot
--
DROP TABLE IF EXISTS question;
CREATE TABLE question(
	question_id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(50)
    
);
-- VD: them 2 question
INSERT INTO question (content) 
VALUES ("Cau hoi MySQl"),
	   ("cau hoi ve java");
TABLE question;
-- khoa chinh 2 cot
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id INT,
    account_id INT,
    join_date DATE,
    PRIMARY KEY (group_id, account_id)
);
-- VD: them 2 group account
INSERT INTO group_account (group_id, account_id, join_date) 
VALUES (1, 1, "2023 - 06 - 19"),
	   (1, 2, "2024 - 12 - 24");


