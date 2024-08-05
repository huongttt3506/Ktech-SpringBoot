CREATE TABLE student(
    id integer primary key AUTOINCREMENT,
    name text,
    email text,
    age  int,
    phone text
);

insert into student(name, email, age, phone)
values('alex', 'alex@gmail.com', 10, '01011112222');