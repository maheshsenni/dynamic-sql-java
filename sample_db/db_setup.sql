CREATE DATABASE IF NOT EXISTS department;
USE department;

CREATE TABLE department.employee (
    emp_no INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    gender ENUM ('M','F') NOT NULL,
    age MEDIUMINT NOT NULL,
    hire_date DATE NOT NULL,
    PRIMARY KEY (emp_no)
);

insert into department.employee(name, gender, age, hire_date) values('Joseph Hopper', 'M', 33, '2019-06-03');
insert into department.employee(name, gender, age, hire_date) values('Scarlette Macgregor', 'F', 26, '2019-06-21');
insert into department.employee(name, gender, age, hire_date) values('Samera Hess', 'F', 31, '2018-07-25');
insert into department.employee(name, gender, age, hire_date) values('Orson Stone', 'M', 23, '2017-02-03');
insert into department.employee(name, gender, age, hire_date) values('Sapphire Mason', 'F', 34, '2020-06-12');
insert into department.employee(name, gender, age, hire_date) values('Dario Ford', 'M', 32, '2020-05-01');
insert into department.employee(name, gender, age, hire_date) values('Ayana Dillon', 'F', 29, '2019-08-23');
insert into department.employee(name, gender, age, hire_date) values('Shelley Dunne', 'F', 33, '2018-07-16');
insert into department.employee(name, gender, age, hire_date) values('Shazia Campos', 'F', 29, '2017-09-18');
insert into department.employee(name, gender, age, hire_date) values('Sumaiyah Mullen', 'F', 37, '2018-11-27');

GRANT ALL PRIVILEGES ON department. * TO 'app_user'@'%';
