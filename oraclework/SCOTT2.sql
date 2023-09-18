--emp테이블에서 ename만 조회하시오
select ename from emp;
--emp테이블에서 이름과 직업만 조회하시오
select ename,job from emp;
--emp테이블 전체조회
select * from emp;
--student 테이블 전체조회
select * from student;
--표현식 //하나의 표현식 column이 더생김
select name,'지금 실습중' from student;
--컬럼 별칭 allias출력
select name "이름",grade as "학년", birthday 생일 from student;
--emp에서 사원명, 직업, 입사일자 을 조회하시오
select ename "사원명",job 직업,hiredate as "입사일자" from emp;
--DISTINCT:중복된 값을 제거하고 출력하기
--EMP에서 직업군을 중복하지말고 출력
select DISTINCT job 직업군 from emp;
--emp에서 부서번호를 중복없이 출력
select DISTINCT deptno 부서번호 from emp;
--합성연산자: 컬럼을 붙여서 출력
select name ||grade 학년별학생명 from student;
--professor 전체조회
select * from professor;
-- 하나의 컬럼으로 출력_조인형 님은 정교수 입니다.
select name ||  '님은' || position || '입니다' "교수별직급" from professor;

--emp 에서 smith님의 job은 clerk 입니다.
select ename || '님의 job은'|| job ||'입니다.'  from emp;
--student 에서 서진수님의 키는 18roundcm, 몸무게는 72kg 입니다.
select name || '님의 키는'|| height||'cm, 몸무게는'|| weight||'kg 입니다.' from student;
--emp에서  내 직업은 slaesman 이고 연봉은 *** 입니다.
select '내 직업은'||job||'이고 연봉은' || sal||'입니다.' from emp;

-- 정렬
-- student에서 학생명, 학년, 생일을 학생명의 오름차순으로 조회하시오.
-- from절이 오고, 그다음 order 절이 온다.명
-- from절은 절대 빠질 수 없다. 
-- order by : 오름차순. 
SELECT name "학생명", grade "학년", birthday "생일" from student order by name asc; -- 오름차순, asc는 생략 가능
SELECT name "학생명", grade "학년", birthday "생일" from student order by name desc; -- 내림차순, desc는 생략 불가능

-- emp에서 사원명, 직업, 급여를 급여가 낮은사람 순으로 조회하세요.
select ename"사원명",job"직업",sal"급여" from emp order by sal desc;
select ename"사원명",job"직업",sal"급여" from emp order by 3 desc; // 3열.. 열로도 조회 가능하다.

--emp 에서 직업군을 중복없이 출력하고 직업군의 오름차순으로 출력하시오.
select distinct job from emp order by job;

--산술연산자
-- emp에서 sal에 특별보너스를 100을 더하여 출력하시오. 
select ename "사원명", sal "기본급", sal+100 "특별보너스" from emp;
--where절 : 조건
--emp에서 10번부서에 근무하는 사람의 사원명, 급여와 부서번호를 출력하세요.
select ename "사원명", sal 급여, deptno 부서번호 from emp where deptno=10; 
--emp 에서 이름이 king인 사람의 사원명, 직업을 조회하시오.
select ename 사원명, job 직업 from emp where ename='KING'; -- 문자 사용시에는 소따옴표 사용, 문자는 대소문자 구별해줘야함.
--emp 에서 급여가 3000 이상인 사람의 사원명 급여를 조회하시오.
select ename 사원명, sal 급여 from emp where sal>=3000;
-- 학생테이블에서 키가 180이상인 학생명과 키를 출력하시오.
select name 학생명, height 키 from student where height>180;
-- 학생테이블에서 키가 160~180 사이인 학생명과 키 출력 (between a and b : a가 작은숫자가 들어가야 한다.)
select name 학생명, height 키 from student where height between 160 and 180 order by height;
-- in(a,b) : a,b만 조회하는 것.
--emp 에서 deptno가 20,30 인 사람들의 사원명과 부서번호를 조회
select ename 사원명, deptno 사원명 from emp where deptno in(20,30);
--null 값만 출력
--emp에서 comm이 null의 인사람의 이름과 보너스를 출력하시오.
select ename  사원명, comm 보너스 from emp where comm is null;
--emp에서 comm이 null 이 아닌사람 이름과 보너스를 출력하시오.
select ename  사원명, comm 보너스 from emp where comm is not null;

-- NVL : null 값을 0 으로 바꾸기 _연산이 목적이다.
select ename 사원명, nvl (comm,0) 보너스 from emp;

-- Like 연산자
-- 학생테이블에서 김씨만 조회하여 모든열을 출력하시오.
select * from student where name like '김%'; -- 김으로 시작하는..
select * from student where name like '%김'; -- 김으로 끝나는..
select * from student where name like '%김%'; -- 김을 포함하는..

-- count    
-- 학생테이블 총 몇명?
select count(*) from student; 
select count(name) from student; 
select count(*) cnt from student; 

-- emp에서 job이 salesman, manager인 사람의 사원명, 직업군만 출력하시오. (or,   in 연산자 )
select ename 사원명, job 직업군 from emp where job='SALESMAN' or JOB='MANAGER';
select ename 사원명, job 직업군 from emp where job in('SALESMAN','MANAGER');

--emp에서 급여가 2000~3000인 사원명, 직업군, 급여를 출력하세요 (and , between연산자) 
select ename 사원명, job 직업군, sal 급여 from emp where sal>=2000 and sal<=3000;
select ename 사원명, job 직업군, sal 급여 from emp where sal between 2000 and 3000;

-- Q.student 테이블에서 1학년 학생의 학생명, 키를 출력하시오. (단 키가 작은순..)
select name 학생명, height 키 from student where grade=1 order by height asc ; 

--Q. student 테이블에서 2학년 학생의 학생명 생일 키 몸무게를 출력하시오(단 생일이 빠른 사람순서)
select name 학생명, birthday 생일, height 키, weight 몸무게 from student order by birthday asc;

--Q. professor 테이블에서 교수들의 이름중 조 씨성을 가진 교수의 교수명 직위 입사일자를 출력하시오.
select name 교수명, position 직위, hiredate 입사일자 from professor where name like '조%';

--Q. emp 에서 사원명, 급여, 급여*12, 보너스, 급여 총계를 구하시오.
select ename 사원명, sal 급여, sal*12 "급여*12", comm 보너스 from emp;

--Q. emp에서 입사일자가 1982/01/01 이후에 들어온 사람의 사원명과 입사일자를 조회하시오 (입사일자 순)
select ename 이름, hiredate 입사일자 from emp where hiredate>'82/01/01' order by hiredate;

-- Like % , _언더바 이용해서 특정순번에 있는 글을 출력한다. 
-- emp에서 사원명이 3번째 글자가 a인 사람의 사원명 출력
select ename 사원명 from emp where ename like '__A%'; 

-- emp에서 사원명이 2번째글자가 a인 사람 또는 3번째 글자가 a인 사람의 사원명 출력
select ename 사원명 from emp where ename like '_A%' or ename like '__A%';

-- 날짜 리터럴 ' ' 반드시 사용
-- emp에서 직급이 clerk이고 입사일이 87/05/23일인 사람의 사원명 입사일 구하기
select ename 사원명, hiredate 입사일 from emp where job='CLERK' and hiredate='87/05/23';

-- EMP에서 매니져이거나 82년 이후 입사자의 사원명 직업군 입사일 출력
SELECT ENAME 사원명, JOB 직업군, hiredate 입사일 from emp where job='MANAGER' or hiredate>'82/01/01';

-- 다중정렬 (1차 정렬의 값이 같을경우 2차 정렬 기준으로 순서를 정한다)
--student에서 1학년 학생의 이름과 키와 몸무게 출력(키는 작은사람부터, 몸무게는 많은사람부터)
select name 학생명, height 키, weight 몸무게 from student where grade=1 order by height asc,weight desc;
--emp에서 급여내림차순 후 다시 이름으로 오름차순_ 사원번호, 사원명, 급여 조회
select empno 사원번호, ename 사원명, sal 급여 from emp order by sal desc,ename asc;

--union
--unionAll
select name from student where deptno1=101 union select name from student where deptno2=201; -- 하나라도 일치하는 사람 (중복 제거) 합집합 
select name from student where deptno1=101 union all select name from student where deptno2=201; -- 하나라도 일치하는 사람 (중복 포함) 
select name from student where deptno1=101 intersect select name from student where deptno2=201; -- 둘다 일치하는 사람 , 교집합

-- Q. gogak point가 30만~ 50만인 조건에서 고객명과 포인트를 출력하세요 (포인트 많은순)
select * from gogak;
select gname 고객명, point 포인트 from gogak where point between 300000 and 500000 order by point desc;

-- Q.emp의 comm의 null을 0으로 바꾸어서 직업이 manager인 사람만 이름과 보너스를 출력하시오.
select ename 이름, nvl(comm,0)"보너스" from emp where job='MANAGER'; 

--Q.professor 103번 학과 교수들의 이름과 급여,보너스,연봉을 출력하시오.
select name 이름, pay 급여, bonus 보너스, pay+bonus "연봉" from professor where deptno=103;

-- SQL 그룹함수(count, sum, avg)
--count(*) : null값 포함, count(컬럼) : null값 제외.

select count(*), count(hpage) from professor;
select count(bonus) from professor;
select count(bonus),sum(bonus) from professor;
select avg(bonus) from professor;

-- max, min
select max(sal),min(sal) from emp;
select max(hiredate),min(hiredate) from emp;

-- 소수점
-- emp에서 sal 평균
select round(avg(sal),1) from emp; -- 소숫점 한자리
select round(avg(sal),2) from emp; -- 소숫점 두자리
select round(avg(sal),0) from emp; -- 반올림
select round(avg(sal),-1) from emp; -- 10 단위
select round(avg(sal),-2) from emp; -- 100 단위

-- 콘솔창에 출력 (from dual)
-- 현재 날짜를 콘솔에 출력 
select sysdate from dual;

-- 내일 날짜를 콘솔에 출력.
select sysdate+1 from dual;

-- to_char : 날짜 및 수치 데이터를 문자로 변환하기위한 함수
-- 날짜에서 년도만 추출
select to_char(sysdate,'year') from dual; -- 영어로 나온다. twenty twenty-three
select to_char(sysdate,'yyyy') from dual; -- 숫자로 나온다. 2023
select to_char(sysdate,'month') from dual; -- 7월
select to_char(sysdate,'mm') from dual; -- 07
select to_char(sysdate,'dd') from dual; --06

select to_char(sysdate,'yyyy-mm-dd') from dual; -- 2023-07-06
select to_char(sysdate,'yyyy-mm-dd hh-mi-ss') from dual; 
select to_char(sysdate,'yyyy-mm-dd hh24-mi-ss') from dual; 

-- to_char 숫자에도 적용 가능하다.
select to_char(12372312,'999,999,999')from dual; -- 천단위 구분기호. 오른쪽 999의 갯수가 최대 자릿수를 결정한다. 결국 999와 ','의 조합으로 자릿수를 표현하는것 같다.

--emp
select empno 사원번호, ename 사원명, to_char(hiredate,'yyyy') 년도 from emp;
--emp에서 사원번호, 사원명, 급여출력(급여는 천단위 구분기호로 표현)
select empno 사원번호, ename 사원명,  to_char(sal,'L999,999') 급여 from emp; -- L 붙히면 원화 표시 나옴

-- 서브쿼리
-- 쿼리안에 또다른 쿼리 담김(KING 보다 급여를 많이 받는 사람은?) 2가지 질문..
-- 서브쿼리가 먼저 수행되어 그 결과를 메인쿼리에 전달해주고, 그 값을 받아 메인쿼리가 실행된다.
-- 서브쿼리 안에는 order by 절을 못사용한다. 

-- emp에서 JAMES보다 급여많이 받는 사람의 사원명 급여를 구해보자.
select ename 이름, sal 급여 from emp where ename='JAMES';
select ename 사원명, sal 급여 from emp where sal>(select sal  from emp where ename='JAMES');
 
 -- emp에서 평균급여보다 많이 받는 사람의 사원번호, 사원명, 급여를 나타내시오.
 select empno 사원번호, ename 사원명, sal 급여 from emp where sal>(select avg(sal) from emp);
 
 -- emp에서 이름이 ward인 사람의 MGR과 같은 값을 가진 사람의 목록
 select * from emp where mgr=(select mgr from emp where ename='WARD');
 
 --emp에서 평균급여보다 많이받는 사람 수?
 select count(*) from emp where sal>(select avg(sal)  from emp);

-- 서브쿼리 문제
-- Q1. emp에서 ADAMS와 같은 직업군을 가진 사람의 이름 연봉 직업군 출력
select ename 이름, sal 연봉, job 직업군 from emp where job=(select job from emp where ename='ADAMS');

--Q2. emp에서 SCOTT와 같은 연봉을 받는 사람의 이름과 연봉 출력
select ename 이름, sal 연봉 from emp where sal=(select sal from emp where ename='SCOTT');

--Q3. student에서 제1전공이 일지매 학생과 동일한 학생들의 학생명 제1전공 출력
select name 학생명, deptno1 제1전공 from student where deptno1=(select deptno1 from student where name='일지매');

--Q4. studetn에서 제1전공이 101인 학과의 평균몸무게보다 몸무게가 많은 학생들의 이름과 몸무게 출력
select name 학생명, weight 몸무게 from student where weight>(select avg(weight) from student where deptno1=101);

--Q5. professor에서 입사일이 김영조 교수보다 나중에 입사한 사람의 이름과 입사일 학과번호 출력
select name 이름, hiredate 입사일, deptno 학과번호 from professor where hiredate>(select hiredate from professor where name='김영조');


-- 2023.07.07 금요일

-- 복습문제
-- Q1. emp에서 job종류별로 직업군을 한번씩 출력해보세요. 
select distinct job 직업군 from emp;

-- Q2. emp 테이블에서 사원명이 A나 S로 시작하는 사람만 출력해보세요 (사원번호  사원명)
select empno 사원번호, ename 사원명 from emp where ename like 'A%' or ename like 'S%';

-- Q3. emp에서 deptno가 10인 부서만 출력하시오 (사원명 부서번호)
select ename 사원명, empno 부서번호 from emp where  deptno=10;

--Q4. emp에서 급여 (sal)가 평균보다 더 높은사람만 사원명 급여를 출력하시오
select ename 사원명, sal 급여 from emp where sal>(select avg(sal) from emp);

--Q5. SCOTT의 급여와 동일하거나 더 많이 받는 사람의 사원명과 급여를 출력하시오.
select ename 사원명, sal 급여 from emp where sal>=(select sal from emp where ename='SCOTT');

--Q6. emp에서 hiredate 에서 월이 5월인 사람만 사원명 입사일자를 출력하시오 (to_cahr 사용)
select ename 사원명, hiredate 입사일자 from emp where to_char(hiredate,'mm')='05';

--1. 테이블 생성
-- primary key는 기본키를 의미한다. nou null+unique를 의미한다.

-- test
create table test (num number(5) primary key, name varchar2(20),score number(6,2), birth date); 

desc test; 

-- 구조보기
select * from test;

-- test에 전체데이터 insert
insert into test values(1,'손석구',67.2,'1993-11-13');


-- test에 일부 데이터 insert
insert into test (num,name) values (2,'강호동');

--insert 에러
--무결성 제약조건 ( ~~~~) 에 위배 
--insert into test valuse(2,'이영애',68.23,'1987-12-13');

insert into test values(4,'이영애',68.23,'1987-12-13');

-- sysdate 현재날짜 의미
insert into test values(5,'이효리',88.34,sysdate);

--alter (구조변경-수정)
-- 나이를 저장할 컬럼 추가, 무조건 null로 추가된다.
-- ALTER TABLE 테이블명 ADD 추가할컬럼명 데이터타입;
alter table test add age number(5);

-- 주소를 저장할 컬럼을 추가하는데 초기값을 강남구라고 지정
alter table test add address varchar2(30) default '강남구';

-- 지정한 숫자를 넘어서 기입하면 오류 난다.
--insert into test values(4,'이영애',68.23,'1987-12-13','대한민국 서울시 ㅎㅎㅎ ㅓㅓㅓ 2324-231ㅓ2ㅑㅐㅓㅐ랴ㅓ래ㅑ저ㅑㅐㄷ러ㅐㅑ3ㅓㅐ2ㅓㅐㅓㅐ2ㅑㅓ래ㅓ래ㅑㅓ32');

-- 주소저장 컬럼을 30에서 50으로 바꿔보자.
-- ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입;
alter table test modify address varchar2(50); 

-- age타입을 문자열 (10)으로 변경하고 초가값을 20으로 설정하기
--기존 null은 그대로 있고(전체 그대로 있고) 새로 insert하는것 부터 초기값 들어감
alter table test modify age varchar2(10) default '20';

insert into test(num,name) values (10,'강호동');


-- num의 오름차순 출력
select * from test order by num;

select * from test order by name;


-- drop (삭제)
-- age라는 컬럼을 삭제 
-- ALTER TABLE 테이블명 DROP COLUMN 삭제할컬럼명
alter table test drop column age;
alter table test drop column address;

-- 컬럼명 변경
-- ALTER TABLE 테이블명 RENAME COLUMN  OLD컬럼명 TO NEW컬럼명;
-- score ==> 점수   로 변경
alter table test rename column score to 점수;
alter table test rename column birth to birthday;



-- 테이블 삭제
drop table test;







-- 시퀀스 생성
-- 시퀀스 기본으로 생성, 1부터 1씩 증가하는 시퀀스 생성됨.

create sequence seq1;


-- 전체시퀀스
select * from seq;

-- 다음 시퀀스값을 발생하여 콘솔에 출력하자
select seq1.nextval from dual;


-- 현재 마지막 발생한 시퀀스값
select seq1.currval from dual;

--seq1 삭제
drop sequence seq1;



-- 10부터 5씩 증가하는 시퀀스 만들기, cache값 없애기
create sequence seq2 start with 10 increment by 5 nocache;

select * from seq;


-- 시퀀스 발생
select seq2.nextval from dual;
select seq2.currval from dual;

drop sequence seq2;


-- sql1 : 시작값:5, 증가값:2, 끝값:30, 캐시:0, cycle:y
create sequence seq1 start with 5 increment by 2 maxvalue 30 nocache cycle;

-- sql2 : 시작값:1, 증가값:1, 캐시:n
create sequence seq2 nocache;

-- sql3 : 시작값:1, 증가값:2, 캐시:n
create sequence seq3 start with 1 increment by 2 nocache;

create sequence seq4 increment by 2 nocache;


-- 출력
select seq1.nextval,seq2.nextval,seq3.nextval from dual;

-- 전체삭제
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;
drop sequence seq4;



--------------------------------- 시퀀스 1개생성, 테이블 생성
create sequence seq_start nocache;
create table personinfo (num number(5) primary key, name varchar2(20), job varchar2(30), gender varchar2(20), age number(5), hp varchar2(20), birthday date);

select * from personinfo;
desc personinfo;

-- birthday를 ipsaday 로 변경
alter table personinfo rename column birthday to ipsaday;

-- insert 
insert into personinfo values (seq_start.nextval, '이성신','메붕이','남자',28,'010-3232-1212','2023-01-11');
insert into personinfo values (seq_start.nextval, '김태희','의사','여자',22,'010-2534-3424','1998-01-11');
insert into personinfo values (seq_start.nextval, '김민중','의사','남자',21,'010-3656-3654','2017-07-12');
insert into personinfo values (seq_start.nextval, '고라니','의사','여자',24,'010-2354-6457','2015-02-11');
insert into personinfo values (seq_start.nextval, '김나박이','백수','여자',24,'010-8892-6745','2022-02-11');
insert into personinfo values (seq_start.nextval, '이존망','백수','여자',27,'010-2342-5343','1999-05-21');
insert into personinfo values (seq_start.nextval, '이린생','메붕이','여자',31,'010-1313-2324','1993-11-13');
insert into personinfo values (seq_start.nextval, '최디알','백수','남자',42,'010-8765-4332','2000-11-11');
insert into personinfo values (seq_start.nextval, '김상식','메붕이','여자',23,'010-3827-1827','2012-12-11');
insert into personinfo values (seq_start.nextval, '박병','메붕이','남자',18,'010-2342-2623','2023-11-11');

commit; -- 최종저장.
-- 커밋을 해야 완료된다. 커밋 안하면 결과적으로 완료한게 아니다.

-- 인원확인
select count(*)  from personinfo;

-- 조회 연습
select * from personinfo order by name asc;
select * from personinfo order by age desc;
select * from personinfo order by 5 asc; -- 컬럼 번호로도 가능.

select * from personinfo order by gender,age desc;  -- 여기서 젠더는 asc로 들어갔다.
select * from personinfo order by gender,name;


select job from personinfo;
select distinct job from personinfo;

select * from personinfo where name like '김%';


-- 핸드폰 마지막 자리가 1212인 사람
select * from personinfo where hp like '%1212';

-- 입사일자가 11월인 사람을 출력하시오.
select * from personinfo where to_char(ipsaday,'mm')='11';


-- 입사일이 올해 인사람을 출력하시오.
select * from personinfo where to_char(ipsaday,'yyyy')='2023';

-- 나이가 20~30 사이인 사람 
select * from personinfo where age between 20 and 30;

-- 직업이 백수 이거나 의사인 사람
select * from personinfo where job='의사' or job='백수';

-- 직업이 백수 이거나 의사가 아닌 사람 
select * from personinfo where job not in ('의사','백수');

-- 평균나이, 소수점 한자리로 구하기
select round(avg(age),1) from personinfo;


-- 내용수정(update) 
-- 3번 직업 나이 수정하기, 
-- 조건이 없으면 모든 데이터가 수정된다.

-- UPDATE 테이블명 SET 컬럼1='변경할데이터' WHERE 컬럼2='데이터값';
-- SQL> UPDATE 테이블명 SET 컬럼1='변경할데이터' WHERE 컬럼1='데이터값';

update personinfo set job='던창',age=35;

-- 잘못수정한 데이터 원래대로 돌려놓기 (커밋전에 해야함. 커밋하면 안됌. 커밋하면 최종버전 느낌)
-- rollback;
rollback;


update personinfo set job='던창',age=35 where num=3;


-- 이씨 이면서 여자인 사람의 젠더를 남자로 수정하기.
update personinfo set gender='남자' where name like '이%' and gender='여자';


-- num이 8번인 사람의 직업을 교사로, 입사일으 2000-12-25 로 변경하기
update personinfo set job='교사', ipsaday='2000-12-25' where num=8;


commit;


-- 삭제
--DELETE FROM 테이블명;
delete from personinfo;

rollback;

delete from personinfo where num=2;

-- 여자중에서 나이가 25세 이상만 모두 삭제
delete from personinfo where gender='여자' and age>25;


-- 핸드폰을 ***-****-**** 으로 수정
update personinfo set hp='***-****-****';


-- 테이블 삭제
-- 시퀀스 삭제
drop table personinfo;
drop sequence seq_start;




-- dept에서 30번 부서를 시애틀로 변경해주세요.
update dept set loc='시애틀' where deptno=40;

-- emp 테이블 Totalsal열을 하나 추가하세요. (number (20)으로 줄것)
alter table emp add Totalsal number(20);

-- emp 테이블 Totalsal에 sal과 comm을 합한 가격을 출력하시오.
update emp set totalsal=sal+nvl(comm,0);

-- emp에서 ward 삭제하시오.
delete from emp where ename='WARD';

-- product 테이블에서 100번을 쵸코파이로 수정하세요.
update product set p_name='쵸코페이' where p_code=100;



--Group by
-- professor에서 학과별로 교수들의 평균급여를 출력하시오.

select deptno, avg(pay)"평균 급여" from professor group by deptno;

-- select절에 사용된 그룹함수 이외의 컬럼이나 현식은 반드시 group by에 사용되어야 한다.

-- professor에서 직급별 평균보너스를 구해보세요.
select position, avg(nvl(bonus,0))"평균 보너스" from professor group by position;
select deptno, position, avg(nvl(bonus,0))"평균 보너스" from professor group by deptno, position;


-- student에서 최고 키와 최고 몸무게를 출력
select grade, max(height) "최고 신장" , max(weight) "최고 몸무게" from student group by grade;


-- 교수의 직급별 총급여와 최고보너스를 구하시오.

select position, sum(pay) "총급여", max(bonus)"최고 보너스" from professor group by position;




-- emp에서 동일한 직업끼리의 사원수
select job "직무", count(job) "사원수" from emp group by job;


-- having 절_조건을 주고 검색하기._반드시 group by 뒤에 쓰인다.
-- 평균급여가 2000 이상인 부서의 부서번호와 평균급여를 구하시오.
select deptno, avg(sal) from emp group by deptno having avg(sal)>2000; 

-- where절은 그룹함수의 비교조건으로 쓸수없다. 

--professor에서  평균급여가 300 이상인 학과의 학과번호와 평균급여를 구하시오
select deptno 학과 , avg(pay) 평균급여 from professor group by deptno having avg(pay)>300;

--professor에서  평균급여가 300 이상인 학과의 학과번호와 평균급여를 구하시오, 단 101학과는 제외하시오.
select deptno 학과 , avg(pay) 평균급여 from professor where deptno not in(101) group by deptno having avg(pay)>300;

--professor에서  평균급여가 300 이상인 학과의 학과번호와 평균급여를 구하시오, 단 101학과는 제외하시오. 내림차순 정렬까지!
select deptno 학과 , avg(pay) 평균급여 from professor where deptno not in(101) group by deptno having avg(pay)>300 order by avg(pay) desc;


-- emp에서 job별로 sal의 평균급여를 구하시오
select job, avg(sal) from emp group by job;

-- professor에서 직급별 총급여를 구하시오.
select deptno, sum(pay) from professor group by deptno;

-- emp에서 직업별 인원수 최대급여 최소급여 출력하세요 (job의 오름차순) 
select job, count (job), max(sal),min(sal) from emp group by job order by job;

-- emp에서 입사년도 그룹로 출력 (입사년도, 인원수, 급여평균(소수점 없이) ) _출력 : 입사년도의 오름차순
select to_char(hiredate,'yyyy') 입사년도, count(*) 인원수, round(avg(sal),0) 평균급여 from emp group by to_char(hiredate,'yyyy') order by to_char(hiredate,'yyyy');


-- Rollup 함수
-- 자동으로 소계/합계 구해주는 함수
-- group by 절에 주어진 조건으로 소계값을 구해준다.
select deptno 학과번호, position 직위, sum(pay) 총급여 from professor group by position, rollup(deptno); -- 정교수 끼리의 합, 조교수 끼리의 합 을 추가로 나타내 준다.

select deptno 학과번호, position 직위, sum(pay) 총급여 from professor group by deptno, rollup(position);

-- count
select position,count(*), sum(pay) from professor group by rollup(position);


-- Cube 함수
-- 전체 총계!
-- rollup처럼 각소계에 전체총계까지 구해준다.
select position,count(*), sum(pay) from professor group by cube(position);

select deptno,count(*), sum(pay) from professor group by cube(deptno,position);
select deptno,count(*), sum(pay) from professor group by rollup(deptno,position);



-- 오늘의 총복습
-- Q1. emp에서 평균연봉이 2000 이상인 부서의 부서번호와 평균급여를 구하시오.
select deptno 부서번호, avg(sal) 평균급여 from emp group by deptno having avg(sal)>2000;

-- Q2. emp에서 deptno별 인원수 구하기
select deptno, count(deptno) from emp group by deptno;

-- Q3. emp에서 job별 인원수를 구하시오(단 인원이 2명이상인곳만 구할것)
select job, count(job) from emp group by job having count(job)>=2;

--Q4. emp에서 job별 급여합계를 구하는데 (president는 제외할것) 급여합계가 5000이상만 구하시고 급여합게가 높은것부터 출력하시오.
-- 출력은 job, 급여총계
select job, sum(sal) from emp where job not in('PRESIDENT') group by job having sum(sal)>=5000 order by sum(sal);



-- 제약조건
-- 테이블 생성
create table sawon (num number(5) CONSTRAINT sawon_pk_num primary key, name varchar2(20), 
gender varchar2(10), buseo varchar2(20) constraint sawon_ck_buseo check(buseo in('홍보부','인사부','교육부')),
pay number(10) default 2000000);

-- 시퀀스 생성
create sequence seq_sawon nocache;

-- 데이터 10개 정도 insert
-- 체크 제약조건(SCOTT.SAWON_CK_BUSEO)이 위배되었습니다
insert into sawon values(seq_sawon.nextval,'이영미','여자','교육부',3500000);
insert into sawon values(seq_sawon.nextval,'김신영','여자','인사부',2700000);
insert into sawon values(seq_sawon.nextval,'소지섭','여자','교육부',4200000);
insert into sawon values(seq_sawon.nextval,'마징가','남자','홍보부',2600000);
insert into sawon values(seq_sawon.nextval,'고레와','남자','교육부',5300000);
insert into sawon values(seq_sawon.nextval,'사이다','남자','교육부',2400000);
insert into sawon values(seq_sawon.nextval,'까마귀','여자','인사부',3100000);
insert into sawon values(seq_sawon.nextval,'김치남','여자','인사부',3500000);
insert into sawon values(seq_sawon.nextval,'이상순','여자','교육부',3400000);
insert into sawon values(seq_sawon.nextval,'김수시','남자','홍보부',2800000);
insert into sawon values(seq_sawon.nextval,'박지은','여자','홍보부',4000000);
insert into sawon values(seq_sawon.nextval,'김형진','남자','교육부',4300000);
insert into sawon values(seq_sawon.nextval,'김치호','여자','교육부',4400000);

commit;

-- Q1. 부서별 인원수와 최고급여, 최저급여 조회
select buseo, count(buseo) 인원수,max(pay) 최고급여, min(pay) 최저급여 from sawon group by buseo;

-- Q2. 위의 쿼리문에서 최고급여, 최저급여에 화폐단위를 붙히고 3자리 컴마도 나오게 해주세요
select buseo, count(buseo) 인원수,to_char(max(pay),'L999,999,999') 최고급여, to_char(min(pay),'L999,999,999') 최저급여 from sawon group by buseo;

-- Q3. 성별 인원수와 평균급여를 출력하시오(인원수 뒤에 명 이라고 나오도록...)
select gender, count(*) || '명' "성별 인원수", avg(pay) from sawon group by gender; 

-- Q4. 부서별 인원수와 평균급여를 구하되 인원이 4명 이상인 경우에만 출력하도록 하세요.
select buseo 부서,count(buseo) "부서별 인원수", round(avg(pay),0) "평균 급여" from sawon group by buseo having count(buseo)>4;

select * from sawon;













-- 2023.07.10 화이팅!

-- Q1. emp에서 ename을 empname으로 변경하세요.
alter table emp rename column ename to empname;

--  Q2. gift에서 7번 노트북을 아이패드로 바꾸세요.
update gift set gname='아이패드' where gname='노트북';
update gift set gname='아이패드' where gno=7;

--  Q3. gift에서 10번 아이폰 9000001~10000000 한행을 추가하세요 
insert into gift values (10,'아이폰',9000001,10000000);

--  Q4.member에서 1003 서새알 멤버를 삭제하시오.
delete from member where name='서새알';
delete from member where no=1002;

--  Q5. emp에서 입사일이 82/01/23 인 사원의 이름, 부서번호, 급여를 출력하시오.
select empname 이름, deptno 부서번호, sal 급여 from emp where hiredate='82/01/23';

--  Q6. emp에서 직무별로 최대급여,최소급여,총급여,평균급여를 출력하시오.
select job 직무, max(sal) 최대급여, min(sal) 최소급여, sum(sal) 총급여, round(avg(sal),2) 평균급여 from emp group by job;

select * from emp;
select * from gift;
select * from member;



----------------------------------
-- Join

-- 1. emp와 dept를 join해서 emp사람들의 부서명을 구해보자.
-- 사원명        부서명      
select e.empname, d.dname from emp e, dept d where e.deptno=d.deptno;
select empname, dname from emp e, dept d where e.deptno=d.deptno; -- 테이블의 고유명일경우 e. d. 생략가능 --
-- 고유한 이름은 앞에 e.d 등을 생략해도 된다.

-- student 와 professor 를 조인하여 다음과 같이 출력하시오.
-- 학번     학생명      지도교수명
select s.studno 학번, s.name 학생명, p.name 교수명  from student s, professor p where s.profno=p.profno; -- where 이후에는 같은 걸 붙여놔야 한다.

-- 학번       학생명     제1전공명       제2전공명
select s.studno 학번, s.name 학생명, d.dname 제1전공명
from student s, department d
where s.deptno1=d.deptno;


-- 교수명      직급      학과명
select p.name 교수명, p.position 직급, d.dname 학과명 from professor p, department d where p.deptno=d.deptno;

--  사원번호     사원명     근무도시
-- e1111       smith    new york
select empno 사원번호, empname 사원명, loc 근무도시 from emp e,dept d where e.deptno=d.deptno;

-- panmae prodect join
-- 판매일자     과자명     전체판매액
select pm.p_date 판매일자, pd.p_name 과자명, pm.p_total 전체판매액 
from panmae pm, product pd 
where pm.p_code=pd.p_code;

select * from panmae;
select * from product;
select * from department;
select * from student;
select * from professor;
select * from emp;
select * from dept;





-- primary키와 porign키를 생성한 조인테이블(부모, 자식) 만들어보기

-- 시퀀스 생성 (sequence 생성)
create sequence seq_shop;

-- shop테이블 생성(부모 테이블)
create table shop(shop_num number(5) primary key, sangname varchar2(30), color varchar2(20));

-- 5개 정도 상품추가
insert into shop values(seq_shop.nextval, '요가매트' , 'pink');
insert into shop values(seq_shop.nextval, '아령' , 'black');
insert into shop values(seq_shop.nextval, '레깅스' , 'beige');
insert into shop values(seq_shop.nextval, '져지' , 'white');
insert into shop values(seq_shop.nextval, '양말' , 'yellow');
commit;


-- cart 1 (자식 테이블)... 상품정보는 shop 테이블의 shop_num값을 외부키로 지정 (겹치지 않아야 한다. primary key가 된다.)
create table cart1(idx number(5) primary key, shop_num number(5) constraint cart_fk_shopnum references shop(shop_num), cnt number(5), guipday date);
-- constraint  : 여기에다가 제약조건을 줄께 라는 의미
-- references : 서로 연결을 시켜준거다. 뒤에꺼가 앞에꺼랑 같은 의미야...


-- cart 2 (자식 테이블)... 상품정보는 shop 테이블의 shop_num값을 외부키로 지정 (겹치지 않아야 한다. primary key가 된다.)
-- 부모테이블의 상품을 지우면 그 상품과 연결된 카트를 자동으로 지워준다 (on delete cascade)
create table cart2(idx number(5) primary key, shop_num number(5) references shop(shop_num) on delete cascade, cnt number(5), guipday date);


-- cart1에 상품 추가 _1번
insert into cart1 values(seq_shop.nextval,1,2,sysdate);
insert into cart1 values(seq_shop.nextval,3,4,sysdate);
insert into cart1 values(seq_shop.nextval,6,4,sysdate); -- 무결성 요류 발생. 부모 테이블에 6번이 없기 때문.
insert into cart1 values(seq_shop.nextval,3,4,sysdate);
insert into cart1 values(seq_shop.nextval,2,1,sysdate);
insert into cart1 values(seq_shop.nextval,4,1,sysdate);
insert into cart1 values(seq_shop.nextval,5,8,sysdate);

delete from cart1 where shop_num=4;
delete from cart1 where shop_num=3;

-- cart2에 상품추가
insert into cart2 values(seq_shop.nextval,4,19,sysdate);
insert into cart2 values(seq_shop.nextval,2,1,sysdate);
insert into cart2 values(seq_shop.nextval,5,4,sysdate);
insert into cart2 values(seq_shop.nextval,1,6,sysdate);
insert into cart2 values(seq_shop.nextval,3,7,sysdate);

delete from cart2 where shop_num=4;

-- cart1은 부모 1,2,5 가 존재,   cart2는 부모 1,2,3,5 가 있다.

-- shop의 1번 상품 삭제?
delete from shop where shop_num=1; -- 무결성 제약조건 위배 : 자식 레코드에 있으면 삭제 불가.
delete from shop where shop_num=3; -- on delete cascade 사용하면 자식 테이블에 상관없이 부모껄 삭제하면 삭제된다.


-- Join 가즈아!!
-- cart1에 담긴 상품을 shop 테이블과 join해서 자세히 출력해보자.
-- 방법 1
select c1.idx, s.shop_num, s.sangname,s.color, cnt, c1.guipday from shop s,cart1 c1 where s.shop_num=c1.shop_num; -- 앞에 단축키 붙이는거 (c1,s) 는 숫자는 안된다.

-- 방법 2
select idx, s.shop_num, sangname, color, cnt, c1.guipday from shop s,cart1 c1 where s.shop_num=c1.shop_num; -- 앞에 단축키 붙이는거 (c1,s) 는 숫자는 안된다.

select * from shop;
select * from cart1;
select * from cart2;





-- 부모
-- Menu 테이블명
-- m_num : 기본키
-- m_name : 음식명
-- price : 가격
--
-- 자식
-- MyOrder 테이블명
-- o_num:기본키
-- m_num: 외부키
-- cnt : 숫자
-- o_date: 현재 날짜



-- 부모테이블
create table menu(m_num number(5) primary key, m_name varchar2(30), price number(20));
create sequence seq_menu;

insert into menu values(seq_menu.nextval,'우동',2000);
insert into menu values(seq_menu.nextval,'돈까스',4000);
insert into menu values(seq_menu.nextval,'김밥',1000);
insert into menu values(seq_menu.nextval,'라면',2500);
insert into menu values(seq_menu.nextval,'만두',1500);




-- 자식테이블(자식테이블에 연결된 부모가 있어도 부모를 삭제할 수 있으며, 부모테이블삭제시 자동으로 자식테이블이 삭제되어야 한다.)
create table myorder(o_num number(10) primary key, 
m_num number (5) constraint myorder_fk_m_name references menu(m_num) on delete cascade, 
cnt number(10), o_date date);


insert into myorder values(seq_menu.nextval,22,3,sysdate);
insert into myorder values(seq_menu.nextval,24,2,sysdate);
insert into myorder values(seq_menu.nextval,25,2,sysdate);
insert into myorder values(seq_menu.nextval,21,1,sysdate);
insert into myorder values(seq_menu.nextval,23,4,sysdate);

-- 최종출력
-- 주문번호     음식명     가격(원단위)      개수(개)      주문일자.

select o_num 주문번호, m_name 음식명, to_char(price,'L999,999') "가격" , cnt||'개' 개수, o_date "주문일자" from menu me, myorder mo where me.m_num=mo.m_num;

commit;

select * from menu;
select * from myorder;


---------------------------------------------------------------------------------------------------------------

create table board (bno number(5) constraint board_pk_bno primary key, writer varchar2(20), subject varchar2(100), writeday date);

-- bord에 5개씩 insert 시키세요
insert into board values(seq_sawon.nextval,'임형준','안녕 클레오파트라',sysdate);
insert into board values(seq_sawon.nextval,'이성신','7강의실 스타 1타',sysdate);
insert into board values(seq_sawon.nextval,'박병주','크아왕',sysdate);
insert into board values(seq_sawon.nextval,'김선범','술꾼',sysdate);
insert into board values(seq_sawon.nextval,'김석진','내가 무릎이다',sysdate);


-- answer 라는 댓글(자식) 생성. -> 부모글 지우면 자식글 삭제되도록 합시다.

create table answer (num number(5) constraint anser_pk_num primary key, bno number(5) constraint answer_fk_bno references board(bno) on delete cascade, 
nickname varchar2(20), content varchar2(30), writeday date);

insert into answer values(seq_sawon.nextval,18,'진평이','선범아 나 오늘 데이트 해야돼..',sysdate);
insert into answer values(seq_sawon.nextval,18,'성신','오늘 숙제해야돼..',sysdate);
insert into answer values(seq_sawon.nextval,18,'성혀니','나 메이플 시작했어..',sysdate);
insert into answer values(seq_sawon.nextval,18,'병주','크아 이기면 나감 ㅅㄱ..',sysdate);
insert into answer values(seq_sawon.nextval,19,'현규','구라 ㄴ ',sysdate);
insert into answer values(seq_sawon.nextval,15,'희찬','세상에서',sysdate);
insert into answer values(seq_sawon.nextval,16,'현규','맞다이 고고 ',sysdate);


-- join 출력
-- 원글번호     작성자     작성자글제목      댓글단사람       댓글내용        원글날짜        댓글날짜    
select b.bno 원글번호, b.writer 작성자, b.subject 글제목, a.nickname 댓글단사람, a.content 댓글내용, b.writeday 원글날짜, a.writeday 댓글날짜 from board b, answer a where b.bno=a.bno;

delete from board where bno=18;

select * from board;
select * from answer;

-- board 를 먼저 삭제
select * from board;  

drop table board;-- 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다 라는 오류와 함께 삭제 불가함..

drop table answer;

drop table board; -- 자식 삭제하고 나니까 부모도 삭제 됌.


drop table cart1;
drop table cart2;
drop table shop;

-- 외부키로 연결이 된 경우 자식테이블 먼저 삭제 후 부모테이블 삭제 가능하다.

commit;

------------------------------------------------------------------------------------------

-- 배달의 민족
--==============================
-- 시퀀스: seq_food
-- 부모
-- food 테이블명
-- fno : 기본키 (시퀀스)
-- foodname : 문자열
-- price : 숫자
-- shopname : 상호명(문자열)
-- loc : 가게 위치 (문자열)
--==============================
-- 자식
-- jumun 테이블 명
-- num 숫자(시퀀스)
-- name : 주문한 사람 이름 (문자열)
-- fno : 외부키
-- addr : 배달 주소 (문자열)

-- 출력
-- 주문번호     주문자     음식명     가격      상호명     가게위치        배달주소        
-- 주문자 이름이 오름차순으로 출력 gogo

create sequence seq_food;

create table food (fno number(10) primary key, foodname varchar2(20),  price number(10), shopname varchar2(20), loc varchar2 (50));

insert into food values(seq_food.nextval,'떡볶이',4000,'쌍용떡볶이','서울시 강남구 역삼동');
insert into food values(seq_food.nextval,'족발',4000,'가족같은 족발','서울시 동작구 상도동');
insert into food values(seq_food.nextval,'짜장면',4000,'니취뽤러마','서울시 관악구 청룡동');
insert into food values(seq_food.nextval,'피자',4000,'표정좀피자','서울시 강동구 천호동');
insert into food values(seq_food.nextval,'부대찌개',4000,'부대차렷','서울시 중랑구 중화동');
insert into food values(seq_food.nextval,'마라탕',4000,'하지마라','서울시 성북구 미아동');


create table jumun (num number(10), name varchar2(20), fno number(10) constraint food_pk_fno references food(fno) on delete cascade, addr varchar2(50));

insert into jumun values(seq_food.nextval,'임형준',2,'서울시 관악구 봉천동');
insert into jumun values(seq_food.nextval,'이성신',5,'서울시 광진구 구의동');
insert into jumun values(seq_food.nextval,'김갑수',5,'서울시 강서구 목동');
insert into jumun values(seq_food.nextval,'이동진',6,'서울시 노원구 노동');
insert into jumun values(seq_food.nextval,'박희찬',1,'서울시 마포구 서교동');
insert into jumun values(seq_food.nextval,'경성수',1,'서울시 서초구 기모동');
insert into jumun values(seq_food.nextval,'민락동',1,'서울시 동작구 숭실동');

select f.fno 주문번호, name 주문자, foodname 음식명, to_char(price,'L999,999,999') 가격, shopname 상호명, loc 가게위치, addr 주문자주소 from food f, jumun j where f.fno=j.fno order by name asc;

commit;

select * from food;
select * from sawon;






