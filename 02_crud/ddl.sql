-- STUDENT 테이블 만들기
CREATE TABLE student (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    email TEXT
);

INSERT INTO student(name, email)
VALUES ('alex', 'alex@gmail.com');

INSERT INTO student(name, email)
VALUES (?, ?);
