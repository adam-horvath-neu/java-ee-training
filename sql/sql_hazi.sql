--drop table work."JOBS";
create table work."JOBS"(
	job_id serial primary key,
	company_name varchar(20),
	job_title varchar(20),
	min_salary integer,
	max_salary integer);

--drop table work."EMPLOYEES";
create table work."EMPLOYEES" (
	emp_id serial primary key,
	first_name varchar(20),
	last_name varchar(20),
	email varchar(30),
	phone_number varchar(15),
	hire_date date,
	job_id integer,
	salary integer,
	foreign key (job_id) references work."JOBS" (job_id)
);


INSERT INTO work."JOBS"(company_name, job_title, min_salary, max_salary)
VALUES ('NEURON','STUDENT',0,0);


INSERT INTO work."EMPLOYEES"(
            first_name, last_name, email, phone_number, hire_date, job_id, salary)
    VALUES ('GABOR','BODIS','eztmostnemadommeg@valami.hu',06904206969,'2017-03-31',1,0);
