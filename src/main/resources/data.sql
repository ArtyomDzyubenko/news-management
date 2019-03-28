insert into NEWS (NEWS_TITLE, NEWS_CREATE_DATE, NEWS_BRIEF, NEWS_CONTENT)
values ('News number ONE title', TO_DATE('2012-09-17', 'yyyy-mm-dd'), 'News number ONE brief', 'News number ONE content');

insert into NEWS (NEWS_TITLE, NEWS_CREATE_DATE, NEWS_BRIEF, NEWS_CONTENT)
values ('News number TWO title', TO_DATE('2012-09-17', 'yyyy-mm-dd'), 'News number TWO brief', 'News number TWO content');

insert into NEWS (NEWS_TITLE, NEWS_CREATE_DATE, NEWS_BRIEF, NEWS_CONTENT)
values ('News number THREE title', TO_DATE('2012-09-17', 'yyyy-mm-dd'), 'News number THREE brief', 'News number THREE content');

-----------------------------------------------------

insert into USERS(USERNAME, PASSWORD, ENABLED)
values('admin','$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 1);

insert into USERS(USERNAME, PASSWORD, ENABLED)
values('user','$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 1);

insert into AUTHORITY(USERNAME, AUTHORITY)
values('admin', 'ROLE_ADMIN');

insert into AUTHORITY(USERNAME, AUTHORITY)
values('user', 'ROLE_USER');

select * from NEWS;
