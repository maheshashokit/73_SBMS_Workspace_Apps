-- creating users table for storing application users
create table application_users(
  username varchar(100) primary key,
  pwd varchar(100),
  user_status bigint,
  created_date date
);

-- creating roles for users in the application
create table application_roles(
  role_name varchar(20),
  username varchar(100),
  created_date date,
  constraint username_fk foreign key(username) 
  references application_users(username)
);

insert into application_users values('Mahesh','$2a$10$C9fBme547AzmqkGXZHf12O/iMsJDc/1ryU7i3xClusoA9txfpBcB2',1,sysdate());
insert into application_users values('Suresh','$2a$10$brc4/OG96tKKdYoVJI.t3OLMSJa0eObYY4r6r9XdlOKEywVCI4REC',1,sysdate());
insert into application_users values('Ashok','$2a$10$pLO710FmmOsBA76nDmL/1eADhd3XToxyk0fqHizutesCG6fDYtR/2',1,sysdate());
insert into application_users values('Ramesh','$2a$10$TmgMXQzd4GGwG5jfQSPbK.5QSad0bw4P1M1xWcxKgxZMvx9fN.0zG',1,sysdate());

insert into application_roles values('ADMIN','Mahesh', sysdate());
insert into application_roles values('MANAGER','Mahesh', sysdate());
insert into application_roles values('CUSTOMER','Suresh', sysdate());
insert into application_roles values('CUSTOMER','Ashok', sysdate());
insert into application_roles values('CLERK','Ashok', sysdate());

commit;

=============================================================
users.ddl 
=========
create table users(username varchar(50) not null primary key,
password varchar(500) not null,
enabled boolean not null);

create table authorities (username varchar(50) not null,
authority varchar(50) not null,
constraint fk_authorities_users foreign key(username) references users(username));

create unique index ix_auth_username on authorities (username,authority);

insert into users values('Mahesh','$2a$10$fL5.FByYA0RSox77JIccP.nnL0aFt7qagdftU2tlUDLAMHL8AE1Ba',true);
insert into users values('Suresh','$2a$10$aL0.eONRAa109vPTMaD0SODR2QjukIjM4wzXbW9Y39RwxKOJPd4Ey',true);
insert into users values('Ashok','$2a$10$UkcZ4bm.iz6/eXy6hswhwudbv2TRylytB69r1Tcm.v4wNBf132Duu',true);
insert into users values('Ramesh','$2a$10$vwir.vWjBr4Y3EQlhwghJeVP2xj8zg9yllQwCohfZGguCy78Tkbti',true);

insert into authorities values('Mahesh', 'ROLE_ADMIN');
insert into authorities values('Mahesh','ROLE_MANAGER');
insert into authorities values('Suresh','ROLE_CUSTOMER');
insert into authorities values('Ashok','ROLE_CUSTOMER');
insert into authorities values('Ashok','ROLE_CLERK');
insert into authorities values('Ashok','ROLE_CASHIER');

select * from users;

select * from authorities;