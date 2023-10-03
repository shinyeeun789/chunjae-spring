CREATE DATABASE haebeop;

USE haebeop;

CREATE TABLE test(
	num INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(100) NOT NULL);

INSERT INTO test VALUES (DEFAULT, '테스트제목1');
INSERT INTO test VALUES (DEFAULT, '테스트제목2');
INSERT INTO test VALUES (DEFAULT, '테스트제목3');
INSERT INTO test VALUES (DEFAULT, '테스트제목4');
INSERT INTO test VALUES (DEFAULT, '테스트제목5');

SELECT * from test;

COMMIT;

CREATE TABLE emp(
	emp_no INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50)
);

INSERT INTO emp VALUES(DEFAULT, 'shin');

SELECT * FROM emp;


-- 트랜잭션 수준 실습
SHOW VARIABLES LIKE 'autocommit%';			-- autocommit 설정 값 확인

SET AUTOCOMMIT = TRUE;        				-- autocommit 설정
SET AUTOCOMMIT = FALSE;       				-- autocommit 해제

SHOW VARIABLES LIKE 'tx_isolation';			-- 트랜잭션의 격리 수준 확인

SET tx_isolation = 'READ-UNCOMMITTED';		-- 트랜잭션 격리 수준 변경