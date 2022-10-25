drop table member;
create table member (
member_id NVARCHAR(12) primary key,
member_pw NVARCHAR(12) not null,
member_name NVARCHAR(4) not null,
member_birth DATE,
member_phone NVARCHAR(13) not null,
member_email NVARCHAR(45) not null,
member_gender NVARCHAR(2)
);

select * from memeber;

drop table user_board;

create table user_board (
post_no int primary key,
post_id NVARCHAR(12),
post_date DATE,
post_pw NVARCHAR(12),
post_subject NVARCHAR(50),
post_text NVARCHAR(500)
);







 