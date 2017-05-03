CREATE TABLE tb_board (
	NO number(6) PRIMARY KEY,
	title varchar2(200) NOT null,
	writer varchar2(30) NOT null,
	content varchar2(4000) NOT null,
	reg_date DATE DEFAULT SYSDATE
);

create SEQUENCE tb_board_seq
START WITH 1
INCREMENT BY 1;

DROP TABLE tb_board;

SELECT * FROM tb_board;

INSERT INTO tb_board (NO, title, writer, content) 
VALUES (tb_board_seq.nextval, '안녕하세요 행님', '김용재', '반갑습니다. 또다시 뵐일이 있겠죠');


SELECT * FROM EMPLOYEES;


SELECT EMPLOYEE_ID || '번의 사원이름은 '  || FIRST_NAME || LAST_NAME || ' 급여는  ' || SALARY * 1000 || ' 입니다.' AS "사원정보" FROM EMPLOYEES;

SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 100;

SELECT * FROM EMPLOYEES WHERE SALARY  BETWEEN 10000 AND 15000;

SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '____';


SELECT * FROM EMPLOYEES WHERE last_name like 'King%';



CREATE TABLE tb_text (
	text_no number(5) PRIMARY KEY, 
	title varchar2(500) NOT NULL, 
	content varchar2(4000) NOT NULL, 
	user_id varchar2(15) NULL,
	reg_time DATE DEFAULT SYSDATE, 
	read_count number(5) NOT NULL, 
	recom_count number(5) NOT NULL

);

ALTER TABLE tb_text
ADD FOREIGN KEY(user_id) REFERENCES tb_user(user_id);

DROP TABLE tb_text;

CREATE TABLE tb_user (
	user_id varchar2(16) PRIMARY KEY,
	password varchar2(16) NOT NULL, 
	email varchar2(60) null
);

DROP TABLE tb_user;


CREATE TABLE tb_read_recom (
	text_no number(5) ,
	user_id varchar2(16) , 
	the_time DATE NOT NULL,
	CONSTRAINT pk_tb_read_recom PRIMARY key(text_no, user_id)
);

DROP TABLE tb_read_recom;

ALTER TABLE tb_read_recom
ADD PRIMARY KEY (text_no, user_id) REFERENCES tb_text(text_no), tb_user(user_id);

--2. 아래 내용을 참고하여 tb_user 에 데이터를 입력하세요
INSERT INTO TB_USER (USER_ID, PASSWORD, EMAIL) VALUES ('root', 'abcd1234', 'root@noname.com');
INSERT INTO TB_USER (USER_ID, PASSWORD, EMAIL) VALUES ('user1', 'abcd1234', 'root@noname.com');
INSERT INTO TB_USER (USER_ID, PASSWORD) VALUES ('user2', 'abcd1234');
INSERT INTO TB_USER (USER_ID, PASSWORD) VALUES ('user3', 'abcd1234');

-- 3. user1 의 암호를 12341234 로 변경하세요
UPDATE TB_USER SET PASSWORD = '12341234' WHERE USER_ID = 'user1';  SELECT * FROM TB_USER WHERE user_id = 'user1';

-- 4. user3 의 이메일을 user3@noname.com 변경하세요
UPDATE TB_USER SET email = 'user3@noname.com' WHERE USER_ID = 'user3';  SELECT * FROM TB_USER WHERE user_id = 'user3';

-- 5. 5. user1 이 글을 입력합니다. ( 이 글을 1 번 글이라 칭합니다. )
INSERT INTO tb_text (TEXT_NO, user_id, title, CONTENT, READ_COUNT, RECOM_COUNT) VALUES (1, 'user1', '오늘하루', '할 일이 없었다.', 0, 0);

-- 6 user2 이 글을 입력합니다. ( 이 글을 2 번 글이라 칭합니다. )
INSERT INTO tb_text (TEXT_NO, user_id, title, CONTENT, READ_COUNT, RECOM_COUNT) VALUES (2, 'user2', '오늘하루', '할 일이 많았다.', 0, 0);

-- 7 user3 이 글을 입력합니다. ( 이 글을 3 번 글이라 칭합니다. )
INSERT INTO tb_text (TEXT_NO, user_id, title, CONTENT, READ_COUNT, RECOM_COUNT) VALUES (3, 'user3', '오늘하루', '할 일이란 과연 무엇일까?', 0, 0);

-- 8. user3 이 1 번 글을 조회합니다.( 2 문장으로 작성합니다)
UPDATE tb_text SET READ_COUNT = READ_COUNT + 1 WHERE USER_ID <> 'user1' AND TEXT_NO = 1 ; SELECT * FROM tb_text WHERE TEXT_NO = 1;
INSERT INTO TB_READ_RECOM (USER_ID, TEXT_NO, the_time) VALUES ('user3', 1, SYSDATE) ;
-- 9. user1 이 1 번 글을 조회합니다.( 2 문장으로 작성합니다)
UPDATE tb_text SET READ_COUNT = READ_COUNT + 1 WHERE USER_ID <> 'user1' AND TEXT_NO = 1 ; SELECT * FROM tb_text WHERE TEXT_NO = 1;
INSERT INTO TB_READ_RECOM (USER_ID, TEXT_NO, the_time) VALUES ('user2', 1, SYSDATE);

-- 10. user2 사용자가 1 번 글을 추천합니다.
UPDATE tb_text SET READ_COUNT = READ_COUNT + 1, RECOM_COUNT = READ_COUNT + 1 WHERE USER_ID <> 'user2' AND TEXT_NO = 1 ; SELECT * FROM tb_text WHERE TEXT_NO = 1;

-- 11. user3 사용자가 1 번글을 추천합니다.
UPDATE tb_text SET READ_COUNT = READ_COUNT + 1, RECOM_COUNT = READ_COUNT + 1 WHERE USER_ID <> 'user3' AND TEXT_NO = 1 ; SELECT * FROM tb_text WHERE TEXT_NO = 1;
INSERT INTO TB_READ_RECOM (USER_ID, TEXT_NO, the_time) VALUES ('user3', 1, SYSDATE);
SELECT * FROM TB_READ_RECOM; 


--1. 112, 118부서를 대상으로 과장과 사원의 이름, 직급, 급여, 부서ID를 조회하되, 급여는 1500 이
--상 4000 이하인 직원만 출력되도록 하시오. 
SELECT * FROM S_EMP WHERE SALARY BETWEEN 1500 AND 4000 AND DEPT_ID IN (112, 118);

--2. 관리자가 없는 직원의 이름, 직급, 급여를 조회하시오. 
SELECT * FROM S_EMP WHERE MANAGER_ID IS NULL;

--3. 직급이 부장이어야 하고 급여는 3000 이상을 받는 직원의 이름, 직급, 급여를 조회하시오.
SELECT * FROM S_EMP WHERE MANAGER_ID = 1 AND SALARY >= 3000; 	

--4. 직급이 부장과 과장인 사람들을 대상을 이름, 직급, 급여를 조회하시오. 단, 부서는 112, 113,
--117, 118 부서중에서 조회해야 하며, 급여는 2300 이상 3000 사이인 직원만 조회되도록
--하시오.
SELECT * FROM S_EMP WHERE  SALARY BETWEEN 2300 AND 3000 AND DEPT_ID IN (112, 113, 117, 118);

--5. 직급이 부장 혹은 과장이면서 03월에 입사한 직원의 이름, 직급, 급여, 입사일을 조회하시오.
SELECT * FROM S_EMP WHERE MANAGER_ID IN (1, 2) AND TO_CHAR(START_DATE, 'MM') = '03'

-- 6. 직원의 연봉에 1000 을 더한 값을 조회하시오. 연봉은 급여에 16을 곱하면 된다.
SELECT (SALARY*16) + 1000 AS SALARY FROM S_EMP 

-- 7. 출력결과가 다음과 같도록 조회하시오. 
---------------------------------
--박구곤 사장의 급여 5000
--손명성 기획부장의 급여 3000
--이은선 영업부장의 급여 3500
--서의홍 총무부장의 급여 3000
--김심선 인사부장의 급여 3200 

SELECT NAME ||' ' || TITLE || '의 급여 ' || SALARY FROM S_EMP WHERE MANAGER_ID = 1 OR MANAGER_ID IS NULL;

--8. 커미션을 받는 직원과 관리자가 있는 직원을 대상으로 급여를 2500이상 받는 직원만 조회하시
--오. 
SELECT * FROM S_EMP WHERE SALARY > 2500 AND COMMISSION_PCT IS NOT NULL;


