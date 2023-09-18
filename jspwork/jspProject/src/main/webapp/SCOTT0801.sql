create sequence seq_1;

create table info(num number(5) primary key, name varchar2(20),hp varchar2(20), age number(3),photo varchar2(100));

insert into info values(seq_1.nextval,'옥동자','010-2341-2222',22,'../img/ani/01.png');
insert into info values(seq_1.nextval,'안나','010-1234-5555',17,'../img/ani/02.png');
insert into info values(seq_1.nextval,'엘사','010-1211-1342',19,'../img/ani/03.png');
insert into info values(seq_1.nextval,'짱구','010-2424-2522',5,'../img/ani/04.png');
insert into info values(seq_1.nextval,'흰둥이','010-5678-5676',3,'../img/ani/05.png');
insert into info values(seq_1.nextval,'봉미선','010-1456-9033',29,'../img/ani/06.png');
insert into info values(seq_1.nextval,'짱아','010-3546-6543',2,'../img/ani/07.png');
insert into info values(seq_1.nextval,'신형만','010-3453-3542',31,'../img/ani/08.png');



select * from info;

delete from info where num=3;

commit;


--team
create table team (num number(5) primary key, name varchar2(20), addr varchar2(50), writeday date);

insert into team values(seq_1.nextval,'길동이','서울시 강남구',sysdate);
insert into team values(seq_1.nextval,'길순이','서울시 강서구',sysdate);
insert into team values(seq_1.nextval,'호동이','서울시 관악구',sysdate);
insert into team values(seq_1.nextval,'포돌이','서울시 강서구',sysdate);
insert into team values(seq_1.nextval,'미달이','서울시 강동구',sysdate);

commit;
select * from team;
