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




CREATE TABLE s_emp
(id             NUMBER(7) primary key,
 name           VARCHAR2(25),
 mailid         VARCHAR2(8),
 start_date     DATE,
 manager_id     NUMBER(7),
 title          VARCHAR2(25),
 dept_id        NUMBER(7),
 salary         NUMBER(11, 2),
 commission_pct NUMBER(4, 2)
);

INSERT INTO s_emp VALUES (
   1, '박구곤', 'sky98',
   to_date('03-05-1990','dd-mm-yyyy'), NULL, '사장',
   118, 5000, NULL);
INSERT INTO s_emp VALUES (
   2, '손명성', '2xxsig',
   to_date('08-05-1990','dd-mm-yyyy'), 1, '기획부장',
   110, 3000, NULL);
INSERT INTO s_emp VALUES (
   3, '이은선', 'ch21175',
   to_date('17-06-1991','dd-mm-yyyy'), 1, '영업부장',
   102, 3500, NULL);
INSERT INTO s_emp VALUES (
   4, '서의홍', 'mquickto',
   to_date('07-04-1990','dd-mm-yyyy'), 1, '총무부장',
   101, 3000, NULL);
INSERT INTO s_emp VALUES (
   5, '김심선', 'aropebur',
   to_date('04-05-1990','dd-mm-yyyy'), 1, '인사부장',
   118, 3200, NULL);
INSERT INTO s_emp VALUES (
   6, '전지영', 'murguhar',
   to_date('18-01-1991','dd-mm-yyyy'), 2, '과장',
   110, 2400, NULL);
INSERT INTO s_emp VALUES (
   7, '김정미', 'enchu',
   to_date('14-05-1990','dd-mm-yyyy'), 2, '과장',
   111, 2400, NULL);
INSERT INTO s_emp VALUES (
   8, '신기웅', 'bbiri',
   to_date('07-04-1990','dd-mm-yyyy'), 2, '과장',
   112, 2100, NULL);
INSERT INTO s_emp VALUES (
   9, '이상헌', 'acatchpo',
   to_date('09-02-1992','dd-mm-yyyy'), 2, '과장',
   113, 2300, NULL);
INSERT INTO s_emp VALUES (
   10, '최순철', 'mhavel',
   to_date('27-02-1991','dd-mm-yyyy'), 2, '과장',
   113, 2300, NULL);
INSERT INTO s_emp VALUES (
   11, '최정선', 'cmagee',
   to_date('14-05-1990','dd-mm-yyyy'), 3, '영업대표이사',
   102, 2450, 10);
INSERT INTO s_emp VALUES (
   12, '안은경', 'hgiljum',
   to_date('18-01-1992','dd-mm-yyyy'), 3, '영업대표이사',
   103, 2500, 12.5);
INSERT INTO s_emp VALUES (
   13, '김석우', 'ysedeghi',
   to_date('18-02-1991','dd-mm-yyyy'), 3, '영업대표이사',
   104, 2650, 10);
INSERT INTO s_emp VALUES (
   14, '박성규', 'mnguyen',
   to_date('22-01-1992','dd-mm-yyyy'), 3, '영업대표이사',
   105, 2650, 15);
INSERT INTO s_emp VALUES (
   15, '신종필', 'adumas',
   to_date('09-10-1991','dd-mm-yyyy'), 3, '영업대표이사',
   106, 2400, 17.5);
INSERT INTO s_emp VALUES (
   16, '이기철', 'emaduro',
   to_date('07-02-1992','dd-mm-yyyy'), 6, '사원',
   110, 2400, NULL);
INSERT INTO s_emp VALUES (
   17, '구원상', 'gsmith',
   to_date('08-05-1990','dd-mm-yyyy'), 6, '사원',
   110, 940, NULL);
INSERT INTO s_emp VALUES (
   18, '서정주', 'anozaki',
   to_date('09-02-1991','dd-mm-yyyy'), 7, '사원',
   111, 1200, NULL);
INSERT INTO s_emp VALUES (
   19, '안창환', 'vpatel',
   to_date('06-08-1991','dd-mm-yyyy'), 7, '사원',
   111, 795, NULL);
INSERT INTO s_emp VALUES (
   20, '윤정숙', 'cnewman',
   to_date('21-07-1991','dd-mm-yyyy'), 8, '사원',
   112, 750, NULL);
INSERT INTO s_emp VALUES (
   21, '장현철','amarkari',
   to_date('26-05-1991','dd-mm-yyyy'), 8, '사원',
   112, 850, NULL);
INSERT INTO s_emp VALUES (
   22, '장혜숙', 'echang',
   to_date('30-11-1990','dd-mm-yyyy'), 9, '사원',
   113, 800, NULL);
INSERT INTO s_emp VALUES (
   23, '강연범', 'rpatel',
   to_date('17-10-1990','dd-mm-yyyy'), 9, '사원',
   106, 795, NULL);
INSERT INTO s_emp VALUES (
   24, '오은경', 'bdancs',
   to_date('17-05-1991','dd-mm-yyyy'), 10, '사원',
   113, 860, NULL);
INSERT INTO s_emp VALUES (
   25, '이용호', 'sschwart',
   to_date('09-05-1991','dd-mm-yyyy'), 10, '사원',
   113, 1100, NULL);
