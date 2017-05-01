CREATE TABLE board (
	board_id number(5) PRIMARY KEY, 
	title VARCHAR2(50) NOT NULL,
	content varchar2(2000) NOT NULL,
	writer VARCHAR(20) NOT NULL,
	group_id number(5) NOT NULL, 
	step number(5) NOT NULL, 
	intent number(5) NOT NULL
);


ALTER TABLE board 
ADD (reg_date DATE DEFAULT SYSDATE);


