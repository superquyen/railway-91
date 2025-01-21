DROP DATABASE IF EXISTS on_tap;
CREATE DATABASE on_tap;
USE on_tap;
DROP TABLE IF EXISTS giang_vien;
CREATE TABLE giang_vien(
	ma_gv INT PRIMARY KEY AUTO_INCREMENT,
    ho_ten VARCHAR(50),
    luong INT
);
DROP TABLE IF EXISTS sinh_vien;
CREATE TABLE sinh_vien(
	ma_sv INT PRIMARY KEY AUTO_INCREMENT,
    ho_ten VARCHAR(50),
    nam_sinh INT,
    que_quan VARCHAR(50)
);
DROP TABLE IF EXISTS de_tai;
CREATE TABLE de_tai(
	ma_dt INT PRIMARY KEY AUTO_INCREMENT,
    ten_dt VARCHAR(50) UNIQUE,
    kinh_phi INT NOT NULL,
    noi_thuc_tap VARCHAR(50)
);
DROP TABLE IF EXISTS huong_dan;
CREATE TABLE huong_dan(
	id INT PRIMARY KEY AUTO_INCREMENT,
    ma_sv INT,
    ma_dt INT,
    ma_gv INT,
    ket_qua VARCHAR(50),
    FOREIGN KEY (ma_sv)
        REFERENCES sinh_vien (ma_sv)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (ma_gv)
        REFERENCES giang_vien (ma_gv)
        ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (ma_dt)
        REFERENCES de_tai (ma_dt)
        ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO giang_vien (ma_gv, ho_ten, luong) VALUES
(1, 'Nguyen Van A', 20000000),
(2, 'Le Thi B', 25000000),
(3, 'Tran Van C', 18000000);

-- Thêm dữ liệu vào bảng SinhVien
INSERT INTO sinh_vien (ma_sv, ho_ten, nam_sinh, que_quan) VALUES
(101, 'Pham Minh D', 2000, 'Ha Noi'),
(102, 'Tran Thi E', 1999, 'Hai Phong'),
(103, 'Le Van F', 2001, 'Da Nang');

-- Thêm dữ liệu vào bảng DeTai
INSERT INTO de_tai (ma_dt, ten_dt, kinh_phi, noi_thuc_tap) VALUES
(201, 'CONG NGHE SINH HOC', 50000000, 'Ha Noi'),
(202, 'AI va Machine Learning', 70000000, 'TP.HCM'),
(203, 'Phat Trien Web', 40000000, 'Da Nang');

-- Thêm dữ liệu vào bảng HuongDan
INSERT INTO huong_dan (ma_sv, ma_dt, ma_gv, ket_qua) VALUES
(101, 201, 1, 'Xuat sac'),
(102, 202, 2, 'Tot'),
(103, 203, 3, 'Kha');

-- 2 a) lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT sinh_vien.*
FROM sinh_vien sv
INNER JOIN huong_dan hd ON hd.ma_sv = sv.ma_sv
WHERE hd.ma_dt IS NULL;
-- 2 b) lấy ra số sinh viên làm đề tài 'công nghe sinh hoc'
-- tự giải
SELECT ma_sv, ho_ten
FROM huong_dan 
RIGHT JOIN sinh_vien USING(ma_sv)
WHERE ma_dt IN(
	SELECT ma_dt 
	FROM de_tai
	WHERE ten_dt LIKE "CONG%HOC");
-- giải
SELECT COUNT(ma_sv)
FROM sinh_vien sv
INNER JOIN huong_dan hd on sv.ma_sv = hd.ma_sv
INNER JOIN de_tai dt on hd.ma_dt = dt.ma_dt
WHERE ten_dt LIKE "CONG%HOC";
-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")

CREATE OR REPLACE VIEW sinh_vien_info AS
SELECT ma_sv, ho_ten, ten_dt , IFNULL ( ten_dt, "chưa có")
FROM sinh_vien
LEFT JOIN huong_dan USING (ma_sv)
LEFT JOIN de_tai USING (ma_dt);

-- Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
-- thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS trigger_04;
DELIMITER $$
CREATE TRIGGER trigger_04
BEFORE INSERT ON sinh_vien
FOR EACH ROW
BEGIN
	IF NEW.nam_sinh <= 1900  THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT = "Năm sinh phải > 1900";
    END IF;
END $$
DELIMITER ;
INSERT INTO sinh_vien (ho_ten, nam_sinh, que_quan)
VALUES ('Pham Minh E', 1800, 'Dien Bien');
-- 5. Hãy cấu hình table sao cho khi xoá 1 sinh viên nào đó thì sẽ tất cả thông tin trong table huong_dan liên quan tới sinh
-- viên đó sẽ bị xoá đi
DROP TRIGGER IF EXISTS trigger_07;
DELIMITER $$
CREATE TRIGGER trigger_07
BEFORE DELETE ON sinh_vien
FOR EACH ROW
BEGIN
	
   DELETE FROM huong_dan WHERE ma_sv = OLD.ma_sv;
	

END $$
DELIMITER ;

