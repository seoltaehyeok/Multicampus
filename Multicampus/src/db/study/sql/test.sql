use shopdb;
select * from buytbl;
select * from usertbl;
-- buytbl에서 groupName이 지정되지 않는 물품을 산 userid를 출력하시오
select userid from buytbl where groupName is null;

-- buytbl에서 groupName이 지정되지 않는 물품을 산 user의 정보를 출력하시오
select * from usertbl where userid in (select userid from buytbl where groupName is null);

-- EJW가 산 물품의 목록과 반복구매한 횟수를 출력 / 양 amount(x)
select prodName, count(*) from buytbl where userid = 'ejw' group by prodname;

-- user가 구매한 목록을 중복없이 출력
select distinct prodname from buytbl;

-- user가 구매한 물품중 가장 비싼 상품과 싼 상품에 대한 정보 출력
select distinct prodname, groupname, price 
from buytbl 
where price = (select max(price) from buytbl) 
or price = (select min(price) from buytbl);

-- user의 이름을 오름차순으로 정렬하시오
select * from usertbl order by name;

-- 휴대전화1,2를 모두 가지고 있는 사람은 몇명인가?
select count(*) from usertbl where mobile1 is not null and mobile2 is not null;

-- userid에 S가 있는 회원의 정보를 출력하시오
select * from usertbl where userid like '%S%';

-- userid에 S가 있는 회원중 나이가 가장 많은 사람과 작은 사람의 나이차를 출력하시오
select max(A.birthYear) - min(A.birthYear) as '나이차이' from (select * from usertbl where userid like '%S%') as A;

--  가장 많은 쇼핑 횟수를 가진 유저는
select * from buytbl;
select userid, count(userid) from buytbl group by userid order by count(userid) desc limit 1;



