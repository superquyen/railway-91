-- LOCAL VERIABLE : Biến cục bộ
-- Phạm vi: trong khối BEGIN ... END
-- DECLARE v_department_id INT;
DROP PROCEDURE IF EXISTS sp_01;
DELIMITER $$
CREATE PROCEDURE sp_01 ()
BEGIN
	SET @a = 19;
	-- DECLARE a INT DEFAULT 100;
    SELECT @a AS a;
END $$
DELIMITER ;
CALL sp_01();
SELECT a;

-- SESSION VARIABLE: Biến session (phiên làm việc)
-- Phạm vi phiên làm việc
-- VD: 
SET @b = 1000;
SELECT @b;

DROP PROCEDURE IF EXISTS sp_02;
DELIMITER $$
CREATE PROCEDURE sp_02 ()
BEGIN
    SELECT @b;
END $$
DELIMITER ;

CALL sp_02();

-- GLOBAL VARIABLE : Biến toàn cục
-- Phạm vi: trong tất cả MySQL



-- Thay đổi giá trị
SET GLOBAL connect_timeout = 3;

-- TRIGGER
-- Thời điểm :AFTER / BEFORE
-- Sự kiện : INSERT /UPDATE / DELETE
-- Tham chiếu : NEW / OLD
-- VD : Tạo trigger xác thực thời gian
-- THỜI ĐIỂM + SỰ KIỆN + 0N
DROP TRIGGER IF EXISTS trigger_01;
DELIMITER $$
CREATE TRIGGER trigger_01
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
	IF NEW.join_date > CURRENT_DATE THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = " Ngày tham gia không hợp lệ";
	END IF;
END $$
DELIMITER ;

INSERT INTO group_account ( account_id, group_id, join_date)
VALUES (1, 10, "3000-01-01");

-- CASE WHEN
-- VD : Sử dụng CASE WHEN in ra số ngày trong tháng
SELECT 
	MONTH(CURRENT_DATE + INTERVAL 4 MONTH) AS month, 
    CASE
		WHEN MONTH(CURRENT_DATE)  = 2 THEN " có 28 hoặc 29 ngày "
        WHEN MONTH(CURRENT_DATE)  IN(4, 6, 9, 11) THEN " tháng có 30 ngày"
        ELSE " Tháng có 31 ngày" 
    END;
    
    