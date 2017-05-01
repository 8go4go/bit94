CREATE TABLE board
(
	board_id              INTEGER  PRIMARY key,
	title                 VARCHAR2(50)  NOT NULL ,
	content               VARCHAR2(4000)  NOT NULL ,
	reg_date              DATE  NULL ,
	writer                VARCHAR(20)  NOT NULL ,
	group                 NUMBER(5)  NOT NULL ,
	step                  NUMBER(5)  NOT NULL ,
	intent                NUMBER(5)  NOT NULL ,
	modified_date         DATE  NOT NULL 
);