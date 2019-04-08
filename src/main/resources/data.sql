insert into NEWS (NEWS_TITLE, NEWS_CREATE_DATE, NEWS_BRIEF, NEWS_CONTENT, NEWS_USERNAME)
values ('News number ONE title', TO_DATE('2012-09-17', 'yyyy-mm-dd'), 'News number ONE brief', 'News number ONE content', 'admin');

insert into NEWS (NEWS_TITLE, NEWS_CREATE_DATE, NEWS_BRIEF, NEWS_CONTENT, NEWS_USERNAME)
values ('News number TWO title', TO_DATE('2012-09-17', 'yyyy-mm-dd'), 'News number TWO brief', 'News number TWO content', 'admin');

insert into NEWS (NEWS_TITLE, NEWS_CREATE_DATE, NEWS_BRIEF, NEWS_CONTENT, NEWS_USERNAME)
values ('News number THREE title', TO_DATE('2012-09-17', 'yyyy-mm-dd'), 'News number THREE brief', 'News number THREE content', 'user');

-----------------------------------------------------

insert into USERS(USERNAME, PASSWORD, ENABLED)
values('admin','$2a$10$j0brNJfR.ft5dsjSL/42zuKWEkmwGold3RYsUy0lWjzdyR5/yjzlG', 1);

insert into AUTHORITY(USERNAME, AUTHORITY)
values('admin', 'ROLE_ADMIN');

delete FROM USERS where USERNAME like 'admin';
delete FROM AUTHORITY where USERNAME like 'admin';

select * from  USERS;
select * from  AUTHORITY;
