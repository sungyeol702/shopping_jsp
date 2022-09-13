CREATE USER 'shoppingdb'@'%' IDENTIFIED BY 'mysql';
GRANT Alter ON jspdb.* TO 'shoppingdb'@'%';
GRANT Create ON jspdb.* TO 'shoppingdb'@'%';
GRANT Create view ON jspdb.* TO 'shoppingdb'@'%';
GRANT Delete ON jspdb.* TO 'shoppingdb'@'%';
GRANT Drop ON jspdb.* TO 'shoppingdb'@'%';
GRANT Grant option ON jspdb.* TO 'shoppingdb'@'%';
GRANT Index ON jspdb.* TO 'shoppingdb'@'%';
GRANT Insert ON jspdb.* TO 'shoppingdb'@'%';
GRANT References ON jspdb.* TO 'shoppingdb'@'%';
GRANT Select ON jspdb.* TO 'shoppingdb'@'%';
GRANT Show view ON jspdb.* TO 'shoppingdb'@'%';
GRANT Trigger ON jspdb.* TO 'shoppingdb'@'%';
GRANT Update ON jspdb.* TO 'shoppingdb'@'%';
GRANT Alter routine ON jspdb.* TO 'shoppingdb'@'%';
GRANT Create routine ON jspdb.* TO 'shoppingdb'@'%';
GRANT Create temporary tables ON jspdb.* TO 'shoppingdb'@'%';
GRANT Execute ON jspdb.* TO 'shoppingdb'@'%';
GRANT Lock tables ON jspdb.* TO 'shoppingdb'@'%';
GRANT Grant option ON jspdb.* TO 'shoppingdb'@'%';

create table member(
id varchar(100) not null,
pwd varchar(100) not null,
name varchar(50) not null,
address varchar(100) default 'addr',
grade tinyint default 1,
total_amount int default 0,
reg_at datetime default current_timestamp,
mod_at datetime,
last_login datetime,
primary key(id)
)default charset=utf8mb4 collate=utf8mb4_general_ci;


create table product(
pno int not null,
pname varchar(100) not null,
price int not null,
category varchar(50) not null,
reg_at datetime default current_timestamp,
mod_at datetime,
description varchar(100) not null,
primary key(pno)
)default charset=utf8mb4 collate=utf8mb4_general_ci;

create table board(
bno bigint not null auto_increment,
title varchar(100) not null,
description text not null,
writer varchar(100) default 'removed user',
reg_at datetime default current_timestamp,
mod_at datetime,
primary key(bno)
)default charset=utf8mb4 collate=utf8mb4_general_ci;

create table review(
rno bigint not null auto_increment,
pno int not null,
title varchar(100) not null,
writer varchar(100) default 'removed user',
description text not null,
image_file text,
reg_at datetime default current_timestamp,
mod_at datetime,
primary key(rno)
)default charset=utf8mb4 collate=utf8mb4_general_ci;

create table comment(
cno bigint not null auto_increment,
bno bigint not null,
writer varchar(100) not null,
content varchar(100)not null,
reg_at datetime default current_timestamp,
primary key(cno)
)default charset=utf8mb4 collate=utf8mb4_general_ci;

create table buylist(
buyer varchar(100) not null,
pno int not null,
buy_date datetime default current_timestamp
)default charset=utf8mb4 collate=utf8mb4_general_ci;























