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

SELECT AUTHORITY, 'Roles' from AUTHORITY WHERE username='admin';

insert into USERS(USERNAME, PASSWORD, ENABLED)
values('admin1','e00cf25ad42683b3df678c61f42c6bda', 1);

insert into AUTHORITY(USERNAME, AUTHORITY)
values('admin1', 'ROLE_ADMIN');

insert into USERS(USERNAME, PASSWORD, ENABLED)
values('user1','24c9e15e52afc47c225b757e7bee1f9d', 1);

insert into USERS(USERNAME, PASSWORD, ENABLED)
values('user2','7e58d63b60197ceb55a1c487989a3720', 1);

insert into AUTHORITY(USERNAME, AUTHORITY)
values('user2', 'ROLE_USER');
