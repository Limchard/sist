create sequence seq_sns;

create table snsboard (b_num number(10) primary key, nick varchar2(20), subject varchar(20), content varchar2(50), wday date);

insert into snsboard values(seq_sns.nextval, '이성신','메이플','난 존나 메붕이다', sysdate);
insert into snsboard values(seq_sns.nextval, '박희찬','크아','난 존나 케피다', sysdate);
insert into snsboard values(seq_sns.nextval, '박병주','크아','난 존나 다오다', sysdate);
insert into snsboard values(seq_sns.nextval, '홍성경','크아','난 디지니다', sysdate);
insert into snsboard values(seq_sns.nextval, '김석진','철권','내가 무릅이다', sysdate);
insert into snsboard values(seq_sns.nextval, '최성현','메이플','이성신보다 잘함', sysdate);
insert into snsboard values(seq_sns.nextval, '진현규','스타','동네북', sysdate);
insert into snsboard values(seq_sns.nextval, '김선섬','술술','소개팅 가즈아!!', sysdate);
insert into snsboard values(seq_sns.nextval, '이민규','노인공경','그래도 왕고는 아니다', sysdate);
insert into snsboard values(seq_sns.nextval, '임형준','백수','동네 아저씨', sysdate);
insert into snsboard values(seq_sns.nextval, '장순영','전자담배','홍보대사', sysdate);


commit;

select * from snsboard;




