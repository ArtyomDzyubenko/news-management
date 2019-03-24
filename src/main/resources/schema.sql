CREATE TABLE NEWS (
    NEWS_ID number(10) not null,
    NEWS_TITLE varchar2(100) not null,
    NEWS_CREATE_DATE varchar2(20) not null,
    NEWS_BRIEF varchar2(500) not null,
    NEWS_CONTENT varchar2(2048) not null
);


ALTER TABLE NEWS
  ADD (
    CONSTRAINT NEWS_PK PRIMARY KEY (NEWS_ID)
  );

CREATE SEQUENCE NEWS_SEQUENCE;

CREATE OR REPLACE TRIGGER NEWS_ON_INSERT
  BEFORE INSERT ON NEWS
  FOR EACH ROW
BEGIN
  SELECT NEWS_SEQUENCE.nextval
  INTO :new.NEWS_ID
  FROM dual;
END;

-------------------------------------------------------------

CREATE TABLE USERS (
    USERNAME varchar2(100) not null,
    PASSWORD varchar2(100) not null,
    ENABLED number(1) check (ENABLED in (0,1)) not null
);

CREATE TABLE AUTHORITY (
    USERNAME varchar2(100) not null,
    AUTHORITY varchar2(50) not null
);

ALTER TABLE USERS
ADD (
  CONSTRAINT USERS_PK PRIMARY KEY (USERNAME)
);

ALTER TABLE AUTHORITY
ADD (
  CONSTRAINT AUTHORITY_PK PRIMARY KEY (USERNAME)
);

ALTER TABLE AUTHORITY
ADD (
  CONSTRAINT USERNAME_PK FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME)
);

