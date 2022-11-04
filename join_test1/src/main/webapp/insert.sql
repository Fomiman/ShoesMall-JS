drop table deliver_address;
drop table memberTBL;
drop table product_category;
drop table productTbl;
drop table managertbl;
drop table user_board;
drop table cartTBL;
drop table orderTBL;
drop table order_detail;
drop table noticeTBL;

show tables;

select * from deliver_address;
select * from memberTBL;
select * from product_category;
select * from productTbl;
select * from managerTbl;
select * from user_board;
select * from cartTBL;
select * from orderTBL;
select * from order_detail;
select * from noticeTBL;


insert into deliver_address values(1, '123','123','123');
update deliver_address set address1='대구광역시', address2='달서구',address3='상인동' where member_code=0;

--delete from memberTBL where member_code in(0,1);
insert into memberTBL values ('000000', 'user123' ,'user123' , 'user','1993-05-03','010-1111-2222','metalwing53@gmail.com','M');

insert into product_category values('나이키','나이키');
insert into product_category values('아디다스','아디다스');
insert into product_category values('기타','기타');

insert into productTBL values 
('1001280','나이키','나이키신발1','280','50000','5','나이키슈즈1은, 조깅할때 발의 편안함과 가볍고 시원한 감을 주는 러닝화 입니다.','2022-10-26','11','nikeshoes1.jsp');
insert into productTBL values 
('1001270','나이키','나이키신발1','270','50000','5','나이키슈즈1은, 조깅할때 발의 편안함과 가볍고 시원한 감을 주는 러닝화 입니다.','2022-10-26','11','nikeshoes1.jsp');

insert into managerTBL values ('admin123', 'admin123' ,'metalwing53@gmail.com');

--insert into user_board;

--insert into cartTBL;

insert into orderTBL values(0,0,'2022-10-29',0);

insert into order_detail values(0,0,1001280,1,50000);
insert into order_detail values(1,0,1001270,1,50000);

insert into noticeTBL values(1, '123','123','2022-10-30');


select  * from Order_detail natural join ordertbl natural join membertbl natural join deliver_address where order_id = 0;
select order_id, member_id,concat(address1, " ", address2, " ", address3) as address, member_phone, member_email, product_no, order_amount, order_price from Order_detail natural join ordertbl natural join membertbl natural join deliver_address  where order_id = 0;

select order_id, member_id,concat(address1, " ", address2, " ", address3) as address,  member_phone, member_email, product_no, order_amount, order_price from Order_detail natural join ordertbl natural join membertbl natural join deliver_address  where order_id = 0;


select member_code, member_id, member_name, member_phone from memberTBL order by 1 desc;

select member_code, member_id, member_pwd, member_name, member_birth, member_phone, member_email, member_gender, address1, address2, address3 from memberTBL natural join deliver_address;

select ifnull(max(notice_no),0)+1 as notice_no from NoticeTBL;


update noticetbl set notice_text='여기에 공지사항 내용을 입력해주세요.' where notice_no=2;

select * from producttbl;

insert into producttbl values(1010280, '나이키', '나이키신발10번', 280, 45000, 10, 'asdasd', '2022-11-03', 0, 'KakaoTalk_20221030_191240594.png');
delete from producttbl where product_no = 1010280;