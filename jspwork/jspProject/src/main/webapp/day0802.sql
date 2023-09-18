create table myfood(num number(3) primary key, foodname varchar2(20), foodphoto varchar2(50), price number(5), cnt number(5));

insert into myfood values(seq_food.nextval,'에그샌드위치','../img/Food/1.jpg',8800,2);
insert into myfood values(seq_food.nextval,'꼬치구이','../img/Food/2.jpg',4500,5);
insert into myfood values(seq_food.nextval,'콘치즈','../img/Food/5.jpg',8000,3);
insert into myfood values(seq_food.nextval,'망고빙수','../img/Food/11.jpg',11000,1);
insert into myfood values(seq_food.nextval,'순두부라면','../img/Food/12.jpg',5500,2);

select * from myfood;

commit;



create table shop(num number(5) primary key, sangpum varchar2(30), color varchar2(20), price number(5), imgname varchar2(50));

insert into shop values(seq1.nextval,'구두','black',77000,'../img/shoppingmall/11.jpg');
insert into shop values(seq1.nextval,'반바지','purple',40000,'../img/shoppingmall/34.jpg');
insert into shop values(seq1.nextval,'모자','brown',50000,'../img/shoppingmall/29.jpg');
insert into shop values(seq1.nextval,'원피스','white',90000,'../img/shoppingmall/28.jpg');
insert into shop values(seq1.nextval,'시계','gold',99000,'../img/shoppingmall/20.jpg');


create table myfriend(num number(5) primary key, fname varchar2(20), fhp varchar2(20), faddr varchar2(20), gaipday date);

insert into myfriend values(seq1.nextval,'이민규','010-2222-3333','서울',sysdate);
insert into myfriend values(seq1.nextval,'이성신','010-1111-4444','시흥',sysdate);
insert into myfriend values(seq1.nextval,'윤호석','010-1234-4321','김포',sysdate);
insert into myfriend values(seq1.nextval,'최성현','010-5678-8765','수원',sysdate);
insert into myfriend values(seq1.nextval,'진현규','010-7654-4567','오산',sysdate);

select * from myfriend;


create table sinsang(num number(5) primary key, name varchar2(20),addr varchar2(30),sdate date);

-- myteam

create table myteam(num number(5) primary key, tname varchar2(20), driver varchar2(20), taddr varchar2(50), writeday date);
select * from myteam;


create table mymall(no number(10), sangpum varchar2(30), photo varchar2(50), price number(10), ipgoday varchar2(20), writeday date);

drop table mymall;

select *from mymall;

commit;

create table intro(intro_num number(10) primary key, intro_name varchar2(20), intro_blood varchar2(20), intro_hp varchar2(50), intro_city varchar2(50), gaipday date);

select * from intro;

commit;



