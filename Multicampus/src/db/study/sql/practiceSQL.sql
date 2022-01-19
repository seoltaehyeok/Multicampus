-- usertbl에 있는 모든 데이터 출력하시오
select * from usertbl;

-- 부서테이블 생성
create table dept(
	dept_code  char(5) not null,
	dept_name varchar(20) not null,
	dept_loc varchar(20) not null
);

-- 부서테이블 데이터 추가
insert into dept values('ABCDE', '개발', '강남');
insert into dept values('BCDEF', '분석', '강북');
insert into dept values('CDEFG', '설계', '강서');

-- 부서테이블 데이터 업데이트
update dept set dept_loc = '강동' where dept_loc = '강서'


-- 사원테이블 생성
create table emp(
	emp_code int AUTO_INCREMENT,
	dept_code char(5),
	emp_name varchar(10) not null,
	emp_age int not null,
	emp_hiredate datetime not null default now(),
	emp_salary int not null default 3000,
	PRIMARY KEY (emp_code),
	FOREIGN KEY (dept_code) REFERENCES dept (dept_code)
);

select * from emp;
-- 사원테이블 데이터 추가
-- emp_code / emp_name / emp_age / emp_hiredate / emp_salary / dept_code
insert into emp values(null, 'CDEFG', 'KIM', 30, default, default);
insert into emp values(null, 'ABCDE', 'LEE', 20, default, 5000);
-- dept_code는 외래키(FK)이므로 dep 테이블에 없는 dept_code값을 넣으면 error가 발생
insert into emp (dept_code, emp_name, emp_age) values('DEFGH', 'PARK', 25);


-- 기사테이블 생성
create table gisaTBL(
	std_no int primary key,
	email varchar(10) not null,
	kor int not null,
	eng int not null,
	math int not null,
	sci int not null,
	hist int not null,
	total int not null,
	mgr_code char(1) not null,
	acc_code char(1) not null,
	loc_code char(1) not null
);

