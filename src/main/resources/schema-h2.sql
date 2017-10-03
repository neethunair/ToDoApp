CREATE TABLE Task
(
    id NUMBER(19) NOT NULL PRIMARY KEY,
    task_name VARCHAR2(50) NOT NULL,
    flag_completed BIT NOT NULL,
    flag_deleted  BIT NOT NULL
);