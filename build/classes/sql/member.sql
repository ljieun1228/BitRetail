SELECT * FROM member;

--계정 생성
CREATE USER oracle IDENTIFIED BY password;
oracle/password
--system 기존 데이터와 섞이지 않도록 새로운 계정을 생성한다.

--현재 사용자 정보
SHOW USER;
SELECT *  FROM TAB ;

--권한 부여
GRANT RESOURCE, CONNECT, DBA TO oracle;


--테이블 생성
CREATE TABLE account(
   accountNum VARCHAR2(10), 
    today VARCHAR2(10), 
    money NUMBER(38,38)); 
    
    
    //멤버 빈 프로퍼티와 동일 타입을 뒤로 붙인다. 


--테이블 삭제

DROP TABLE member;

--인스턴스 생성
DB에서 한 row 를 추가하는 것
INSERT INTO member(id, name, pass, ssn)
VALUES('hong', '홍길동', '1', '900101-1234567');


SELECT * FROM member;

delete from member where name like '이지은';
