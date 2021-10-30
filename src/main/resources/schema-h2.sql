CREATE TABLE BLOG
        (
        id NUMBER(100) auto_increment NOT NULL,
        content VARCHAR2(4000) NOT NULL,
        likes NUMBER(100),
        PRIMARY KEY(id)
        );


CREATE TABLE COMMENT
        (
        id NUMBER(100) auto_increment NOT NULL,
        content VARCHAR2(4000) NOT NULL,
        likes NUMBER(100),
        blog_id NUMBER(100),
        parent_comment NUMBER(100),
        PRIMARY KEY(id)
        );