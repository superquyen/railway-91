-- STORED PROCEDURE : thủ tục luu trữ 
-- VD : tạo thủ tục tìm kiếm phòng ban theo id

-- Xoá thủ tục nếu tồn tại
DROP PROCEDURE IF EXISTS sp_01;

-- Tạo thủ tục
DELIMITER $$
CREATE PROCEDURE sp_01 (IN in_department_id INT)
BEGIN
	SELECT *
    FROM department
    WHERE department_id = in_department_id;
END $$
DELIMITER ;

-- gọi thủ tục

CALL sp_01();

-- VD: tạo thủ tục lấy ra tất cả developer

DROP PROCEDURE IF EXISTS sp_02;
DELIMITER $$
CREATE PROCEDURE sp_02 ()
BEGIN
    DECLARE v_position_id INT;
    
    SELECT position_id INTO v_position_id
    FROM position
    WHERE position_name = "Dev";

    SELECT *
    FROM account
    WHERE position_id = v_position_id;
END $$
DELIMITER ;

CALL sp_02();

-- Từ khóa: IN / OUT / INOUT
-- VD: Tạo thủ tục trả về tên phòng ban theo id
DROP PROCEDURE IF EXISTS sp_03;
DELIMITER $$
CREATE PROCEDURE sp_03 (
    IN in_department_id INT,
    OUT out_department_name VARCHAR(50)
)
BEGIN
    SELECT department_name INTO out_department_name
    FROM department
    WHERE department_id = in_department_id;
END $$
DELIMITER ;

SET @department_name = NULL;
CALL sp_03(8, @department_name);
SELECT @department_name;

-- FUNCTION: Hàm
-- VD: Tạo function trả về tên phòng ban theo id
SET GLOBAL log_bin_trust_function_creators = TRUE;
DROP FUNCTION IF EXISTS fn_01;
DELIMITER $$
CREATE FUNCTION fn_01 (in_department_id INT) RETURNS VARCHAR(50)
BEGIN
    DECLARE v_department_name VARCHAR(50);
    
    SELECT department_name INTO v_department_name
    FROM department
    WHERE department_id = in_department_id;
    
    RETURN v_department_name;
END $$
DELIMITER ;
SELECT fn_01(10);

