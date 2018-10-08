insert into USER_PROFILE(id, type) values(nextval('user_profile_id_seq'::regclass), 'ADMIN');

insert into USER_PROFILE(id, type) values(nextval('user_profile_id_seq'::regclass), 'DBA');

insert into "USER"(id, email, first_name, last_name, password, user_name) values(1, 'joyson.ullal@gmail.com', 'Joyson', 'Dsouza', '$2a$10$gmSRbqDnT3x7VUd7A64qCOcu1UEALTRi.5uOpVFljxvGLS/CmE3Ku
', 'joyson');

insert into USER_USER_PROFILE(user_id, user_profile_id) values (1,1);

CREATE SEQUENCE USER_DOCUMENT_ID_SEQ;
CREATE TABLE USER_DOCUMENTS (id serial NOT NULL, document_name varchar(128) NOT NULL, document_mimetype varchar(128) NOT NULL, document_data longblob, PRIMARY KEY (id));

insert into USER(email, firstname, lastname, password, username,age,maritalstatus,contactnumber,projectname,salary,experience) values('joyson.ullal@gmail.com', 'Joyson', 'Dsouza', '$2a$10$gmSRbqDnT3x7VUd7A64qCOcu1UEALTRi.5uOpVFljxvGLS/CmE3Ku', 'joyson','20','single','8907654213','AGI','300000','4');

 create table USER_USER_PROFILE(USER_ID int(11) NOT NULL,FOREIGN KEY (USER_ID) REFERENCES USER (ID) ON UPDATE CASCADE ON DELETE CASCADE,USER_PROFILE_ID int(11) NOT NULL ,FOREIGN KEY (USER_PROFILE_ID) REFERENCES USER_PROFILE (ID)ON UPDATE CASCADE ON DELETE CASCADE);










