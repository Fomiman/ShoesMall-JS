select * from managerTbl;
select * from productTbl;
insert into managerTBL values ('admin123', 'admin123' ,'metalwing53@gmail.com');
insert into memberTBL values ('000000', 'user123' ,'user123' , 'user','1993-05-03','010-1111-2222','metalwing53@gmail.com','M');
insert into product_category values('나이키','나이키');
insert into product_category values('아디다스','아디다스');
insert into product_category values('기타','기타');
insert into productTBL values 
('1001','나이키','나이키신발1','280','50000','5','나이키슈즈1은, 조깅할때 발의 편안함과 가볍고 시원한 감을 주는 러닝화 입니다.','2022-10-26','11','nikeshoes1.jsp');


select * from memberTBL;
select member_id from memberTBL where member_id='user123' and member_pwd='user123';
select manager_id from managerTBL where manager_id='admin123' and manager_pwd='admin123';

show tables;

drop table managertbl;

select * from memberTBL natural join deliver_address where member_id=123; 
insert into deliver_address values(0,'','','');
insert into deliver_address values(1,'','','');

select * from deliver_address;

update deliver_address set address1=123123, address2=123, address3=123 where member_code=1;