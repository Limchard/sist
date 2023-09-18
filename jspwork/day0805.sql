select * from intro;

create table memo(num number(10) primary key, writer varchar2(20), story varchar2(1000), avata varchar2(50), writeday date);

select * from memo; 

insert into memo values(seq1.nextval,'진규','졸귀탱','../img/avata/b1.png',sysdate);

commit;



create table ajaxboard(num number(5) primary key, writer varchar2(20), subject varchar2(50), story varchar2(1000), avata varchar2(100), writeday date);

insert into ajaxboard values(seq1.nextval,'이성신','오늘메이플하실분','오늘일퀘해야합니다','../img/ani/15.png',sysdate);

select * from ajaxboard; 

commit;

drop table ajaxboard;

delete from ajaxboard where num=188;

create table myschool(num number(5) primary key, myid varchar2(40), mypass varchar2(40),myname varchar2(40),myadminvarchar2(40),myhpvarchar2(40),myaddrvarchar2(40),mybirthday varchar2(40),mygrade varchar2(40),myclass varchar2(40),writeday date)