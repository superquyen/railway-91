DROP DATABASE IF EXISTS assignment_01;
CREATE DATABASE assignment_01;
USE assignment_01;

-- tao bang department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id INT,
    department_name VARCHAR(50)
);
-- tao bang position
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
	position_id INT,
    position_name ENUM("Dev", "Test", "Scrum Master", "PM")
);
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id INT,
    email VARCHAR(50),
    user_name VARCHAR(50),
    full_name VARCHAR(50),
    department_id INT,
    position_id INT,
    create_date DATE
);
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id INT,
    acount_id INT,
    joindate DATE

);
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	group_id INT,
    account_id INT,
    joinDate DATE
);
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
	type_id INT,
    type_name ENUM("Essay", "multiple-choice")

);
DROP TABLE IF EXISTS category_question;
CREATE TABLE CategoryQuestion(
	category_id INT,
    category_name VARCHAR(50)
);
DROP TABLE IF EXISTS question;
CREATE TABLE question(
	question_id INT,
    content VARCHAR(50),
    category_id INT,
    type_id INT,
    creator_id INT,
    create_date DATE
    
);
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
	answer_id INT,
    content VARCHAR(100),
    question_id INT,
    iscorrect BOOLEAN
);
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
	exam_id INT,
    `Code` INT,
    title VARCHAR(50),
    category_id INT,
    duration INT,
    creator_id INT,
    create_date DATE
);
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
	exam_id INT,
    question_id INT
);

