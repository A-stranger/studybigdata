set names gbk;
drop database if exists mybatis2;
create database mybatis2 default charset utf8 collate utf8_general_ci;

use mybatis2;
drop table if exists t_student;
drop table if exists t_type;

create table t_type(
    id int(11) primary key auto_increment,
    name varchar(20) not null
);

create table t_student(
    id int(11) primary key auto_increment,
    name varchar(20) not null,
  	age tinyint(4) not null,
  	sex char(1) not null,
  	account varchar(16) not null,
  	password varchar(64) not null,
  	type_id int(11) not null,
    foreign key(type_id) references t_type(id)
);

insert into t_type(name) values('管理员');
insert into t_type(name) values('用户');

insert into t_student(name, age,sex,account,password, type_id) values('张三', 18, 'f','zhangsan','123',1);
insert into t_student(name, age,sex,account,password, type_id) values('李四', 19, 'm','lisi','123',1);
insert into t_student(name, age,sex,account,password, type_id) values('王五', 20, 'f','wangwu','123',2);
