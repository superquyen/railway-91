DROP DATABASE IF EXISTS lesson_02;
CREATE DATABASE lesson_02;
USE lesson_02;

-- Tạo bảng department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
    department_id INT,
    department_name VARCHAR(50)
);

-- Thêm dữ liệu vào bảng
INSERT INTO department (department_id, department_name)
VALUES (1, "Giám đốc"),
       (2, "Bảo vệ"  );

-- Hiển thị dữ liệu
TABLE department;

-- Ràng buộc dữ liệu (Constraints)
-- NULL / NOT NULL
DROP TABLE IF EXISTS student;
CREATE TABLE student (
    email VARCHAR(50) NOT NULL
);
-- VD: Thêm student có email là NULL
INSERT INTO student (email) VALUES (NULL);

-- UNIQUE KEY: Duy nhất
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    phone CHAR(10) UNIQUE NOT NULL
);
-- VD: Thêm 2 customer có phone giống nhau
INSERT INTO customer (phone)
VALUES ("0987654321"),
       ("0987654321");

-- DEFAULT: Mặc định
DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
    is_correct BOOLEAN DEFAULT FALSE,
    create_date DATE DEFAULT (CURRENT_DATE)
);
-- VD: Thêm answer không truyền vào create_date
INSERT INTO answer (is_correct)
VALUES (TRUE);

-- CHECK: Kiểm tra
DROP TABLE IF EXISTS account;
CREATE TABLE account (
    age INT CHECK (age >= 18)
);
-- VD: Thêm account có age = 15
INSERT INTO account (age) VALUES (15);

-- PRIMARY KEY: Khóa chính
-- Yêu cầu: UNIQUE + NOT NULL
-- 1. Một bảng có tối đa một khóa chính
-- 2. Một khóa chính có một hoặc nhiều cột
-- AUTO_INCREMENT: Tự động tăng
-- VD: Khóa chính một cột
DROP TABLE IF EXISTS question;
CREATE TABLE question (
    question_id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(50)
);
-- VD: Thêm 2 question
INSERT INTO question (question_id, content)
VALUES ("Câu hỏi MySQL"),
       ("Câu hỏi Java ");
-- VD: Khóa chính 2 cột
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account (
    group_id INT,
    account_id INT,
    join_date DATE,
    PRIMARY KEY (group_id, account_id)
);
-- VD: Thêm 2 group account
INSERT INTO group_account (group_id, account_id, join_date)
VALUES (1, 1, "2023-06-19"),
       (1, 1, "2024-12-24");

-- FOREIGN KEY: Khóa ngoại
-- Sự kiện: UPDATE, DELETE
-- Hành động: NO ACTION, SET DEFAULT, SET NULL, CASCADE
DROP TABLE IF EXISTS department;
CREATE TABLE department (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);
DROP TABLE IF EXISTS account;
CREATE TABLE account (
    id INT,
    username VARCHAR(50),
    department_id INT,
    FOREIGN KEY (department_id)
        REFERENCES department (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
-- VD: Thêm dữ liệu
INSERT INTO department (id, name)
VALUES (1, "Giám đốc"),
       (2, "Bảo vệ"  );
INSERT INTO account (id, username, department_id)
VALUES (1, "khoa.nv", 3);