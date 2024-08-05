DROP TABLE IF EXISTS student;
CREATE TABLE student(
    id integer primary key AUTOINCREMENT,
    name text,
    email text,
    age  int,
    phone text
);

INSERT INTO student(name, email, age, phone)
VALUES('alex', 'alex@gmail.com', 10, '01011112222');

INSERT INTO student(name, email, age, phone)
VALUES('brad', 'brad@gmail.com', 10, '01011112222');

-- UPDATE student SET 
--     name = ?, 
--     email = ?, 
--     age = ?, 
--     phone = ? 
-- WHERE id = ?;

-- DELETE FROM student
-- WHERE id = ?;
