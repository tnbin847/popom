create database popom_db;
use popom_db;


create user 'devmaster'@'%' identified by 'tnbin847';
grant all privileges on popom_db.* to 'devmaster'@'%';


flush privileges;


create table user (
	id						bigint				unique not null auto_increment comment '사용자계정번호',
	login_id				varchar(20)			not null comment '계정 로그인 아이디',
	password				varchar(255)		not null comment '계정 비밀번호',
	name					varchar(12)			not null comment '사용자 이름',
	email					varchar(40)			not null comment '이메일',
	login_type				varchar(7)			not null comment '로그인 유형(GENERAL : 일반가입 / OAUTH : 소셜가입)',
	activated				tinyint(1)			not null comment '계정활성화여부 (1: 활성화 / 0: 비활성화)',
	created_date			datetime			not null default now() comment '가입일자',
	updated_date			datetime			not null comment '변경일자',
	primary key (id)
) engine = innodb default charset = utf8mb4 comment '사용자 계정';


create table user_authority (
	user_id					bigint				not null comment '사용자계정번호',
	role					varchar(20)			not null comment '부여된 권한명',
	used_at					char(1)				not null comment '권한사용여부',
	created_date			datetime			not null comment '등록일자',
	updated_date			datetime			not null comment '변경일자',
	foreign key (user_id) references user (id) on update cascade on delete cascade
) engine = innodb default charset = utf8mb4 comment '사용자 계정별 권한 정보';