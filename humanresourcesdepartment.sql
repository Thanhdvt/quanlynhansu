CREATE DATABASE humanresourcesdepartment;

USE humanresourcesdepartment;

CREATE TABLE employee (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    position VARCHAR(50) NOT NULL,
    status_employee BOOLEAN NOT NULL,
    salary DOUBLE PRECISION NOT NULL
);

CREATE TABLE work_day (
    id BIGINT PRIMARY KEY,
    employee_id BIGINT REFERENCES employee(id),
    date DATE NOT NULL,
    has_work BOOLEAN NOT NULL
);

CREATE TABLE info_rest (
    id BIGINT PRIMARY KEY,
    seson VARCHAR(255) NOT NULL,
    start_day DATE NOT NULL,
    end_day DATE NOT NULL,
    status_employee VARCHAR(50) NOT NULL,
    created_day TIMESTAMP NOT NULL,
    modified_day TIMESTAMP NOT NULL,
    employee_id BIGINT REFERENCES employee(id),
    leader_id BIGINT REFERENCES employee(id)
);


-- Thêm dữ liệu cho bảng employee
INSERT INTO employee (id, name, birthday, gender, address, phone_number, email, password, position, status_employee, salary)
VALUES (1, 'Nguyen Van A', '1990-01-01', 'Nam', 'Ha Noi', '0123456789', 'thanhak2k2@gmail.com', '123456', 'Nhan vien', true, 10000000);
INSERT INTO employee (id, name, birthday, gender, address, phone_number, email, password, position, status_employee, salary)
VALUES (2, 'Nguyen Van B', '1995-01-01', 'Nam', 'Ha Noi', '0123456789', 'thanhdvt07022002@gmail.com', '123456', 'Nhan vien', true, 18000000);


-- Thêm dữ liệu cho bảng work_day
INSERT INTO work_day (id, employee_id, date, has_work)
VALUES (1, 1, '2023-08-01', true);



-- Thêm dữ liệu cho bảng info_rest
INSERT INTO info_rest (id, seson, start_day, end_day, status_employee, created_day, modified_day, employee_id, leader_id)
VALUES (1, 'Nghi om', '2023-08-20', '2023-08-23', 'Dang xu ly', now(), now(), 1, 2);

select count(bc.date) 
from work_day bc 
where bc.employee_id = 2 and month(bc.date) = 8 and bc.has_work = true;

select *
from info_rest
where DAY(modified_day ) = 21;

