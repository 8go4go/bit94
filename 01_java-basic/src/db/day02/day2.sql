select DEPT_ID, max(SAL) as SAL from TB_GROUP
group by DEPT_ID
order by SAL desc;

desc Employees;

select DEPARTMENT_,ID, max(salary) as SAL from Employees
group by DEPARTMENT_ID
having max(salary) >= 10000
order by SAL desc;


select DEPARTMENT_ID, AVG(salary) as from EMPLOYEES
GROUP by DEPARTMENT_ID
having DEPARTMENT_ID <= 100 and AVG(salary) >= 5000
order by DEPARTMENT_ID desc ;


select count(*) from tb_board;

select to_char(to_date('2017-05-02', 'yyyy, mm, dd'), 'yyyy, mm, dd') as DateFormat from dual;
select substr('2017-05-02', 1,4), substr('2017-05-02', 6,2), substr('2017-05-02', 9,2)
from dual;



select to_number('892,768', '999,999') from dual;

desc s_emp;

select MONTHS_BETWEEN
       (TO_DATE(sysdate,'YYYY/MM/dd'),
        TO_DATE(START_DATE,'YYYY/MM/dd')) from EMPLOYEES;




--==============
-- 그룹

create table tb_group (
    id varchar2(3),
    sal number,
    job_id varchar2(2),
    dept_id number
);  
  
insert into tb_group values('a', 1000, 'SA', 10);  
insert into tb_group values('b', 2000, 'CM', 30);  
insert into tb_group values('c', 3000, 'CM', 20);  
insert into tb_group values('d', 4000, 'LA', 10);  
insert into tb_group values('e', 3000, 'SA', 30);  
insert into tb_group values('f', 2000, 'SA', 10);


-- 조인
create table salgrade (
    grade char(1),
    min_sal number(6),
    max_sal number(6)
);

insert into salgrade values ('1', 20000, 100000);
insert into salgrade values ('2', 10000, 19999);
insert into salgrade values ('3', 6000, 9999);
insert into salgrade values ('4', 3000, 5999);
insert into salgrade values ('5', 1, 2999);


-- set 연산자
create table tc_seta (
    no number,
    data varchar2(2)
);

create table tc_setb (
    no number,
    data varchar2(2)
);

insert into tc_seta values(1, 'a');
insert into tc_seta values(2, 'b');
insert into tc_seta values(3, 'c');
insert into tc_seta values(4, 'd');

insert into tc_setb values(3, 'c');
insert into tc_setb values(4, 'd');
insert into tc_setb values(5, 'e');
insert into tc_setb values(6, 'f');

commit;