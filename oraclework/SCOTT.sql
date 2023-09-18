
-- 시퀀스
create sequence seq1;
-- 테이블 (myinfo)
create table myinfo (num number(5) primary key, name varchar2(20), addr varchar2(30), sdate date);


select * from myinfo;

delete from myinfo where num=1;


------------------------------------ 
-- shop


-- myshop
-- shopnum -숫자(5) 기본키
-- sangpum-문자열(20)
-- su-숫자(5)
-- price-숫자(10)
-- ipgo-날짜 
--


create table myshop (shopnum number(5) primary key, sangpum varchar2(20), su number(5), price number(10), ipgo date);


select * from myshop;



create sequence seq_stu;

create table mystudent (stu_num number(5) primary key, stu_name varchar2(20), stu_grade number(5), hp varchar2(20), addr varchar2(30), age number(5), sdate date);

select * from mystudent;

select * from sawon;

rollback;








