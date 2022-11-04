w-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shoes_shoppingMall
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shoes_shoppingMall
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shoes_shoppingMall` DEFAULT CHARACTER SET utf8 ;
USE `shoes_shoppingMall` ;

-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`deliver_address`
-- -----------------------------------------------------

drop table deliver_address;
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`deliver_address` (
  `member_code` INT NOT NULL COMMENT 'foreign key\n',
  `address1` VARCHAR(20) NOT NULL,
  `address2` VARCHAR(50) NOT NULL,
  `address3` VARCHAR(20) NOT NULL)
ENGINE = InnoDB;

select * from deliver_address;
-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`memberTBL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`memberTBL` (
  `member_code` INT NOT NULL,
  `member_id` NVARCHAR(12) NOT NULL,
  `member_pwd` NVARCHAR(12) NULL,
  `member_name` NVARCHAR(4) NULL,
  `member_birth` DATE NULL,
  `member_phone` VARCHAR(45) NULL,
  `member_email` VARCHAR(45) NULL,
  `member_gender` VARCHAR(45) NULL,
  PRIMARY KEY (`member_code`, `member_id`))
ENGINE = InnoDB;


select ifnull(max(member_code),0)+1 as member_code from memberTBL;
select max(member_code) from memberTBL;
select * from memberTBL;
delete from memberTBL where member_code in(0,1);
-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`product_category` (
  `category_code` VARCHAR(30) NOT NULL,
  `category_name` VARCHAR(45) NULL,
  PRIMARY KEY (`category_code`))
ENGINE = InnoDB;

insert into product_category values ('나이키','나이키');
insert into product_category values ('아디다스','아디다스');
insert into product_category values ('기타','기타');


-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`productTBL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`productTBL` (
  `product_no` INT NOT NULL,
  `category_code` VARCHAR(30) NOT NULL COMMENT '카테고리 나눔 기준은 메이커(나이키, 아디다스, 기타)',
  `product_name` VARCHAR(50) NOT NULL,
  `product_size` INT NOT NULL,
  `product_price` INT NOT NULL,
  `product_amount` INT NOT NULL DEFAULT 0,
  `product_decs` TEXT NOT NULL,
  `product_date` DATE NOT NULL,
  `product_hits` INT NULL DEFAULT 0,
  `product_image` VARCHAR(300) NULL,
  PRIMARY KEY (`product_no`),
  INDEX `fk_product_product_category1_idx` (`category_code` ASC) VISIBLE,
  CONSTRAINT `fk_product_product_category1`
    FOREIGN KEY (`category_code`)
    REFERENCES `shoes_shoppingMall`.`product_category` (`category_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

show tables;

select * from productTBL;

insert into productTBL values (0,'boardSeq');



delete from productTBL
where product_no='1004280';

insert into productTBL values 
('1001260','나이키','나이키신발1','260','50000','5','나이키슈즈1은, 조깅할때 발의 편안함과 가볍고 시원한 감을 주는 러닝화 입니다.','2022-10-26','11','nikeshoes1.jpg');
insert into productTBL values 
('1001270','나이키','나이키신발1','270','50000','5','나이키슈즈1은, 조깅할때 발의 편안함과 가볍고 시원한 감을 주는 러닝화 입니다.','2022-10-26','11','nikeshoes1.jpg');
insert into productTBL values 
('1001280','나이키','나이키신발1','280','50000','5','나이키슈즈1은, 조깅할때 발의 편안함과 가볍고 시원한 감을 주는 러닝화 입니다.','2022-10-26','11','nikeshoes1.jpg');

insert into productTBL values 
('1002260','나이키','나이키신발2','260','60000','6','나이키슈즈2은, 평소에 데일리룩과 매칭이 잘어울리는 나이키 단화 입니다.','2022-10-26','38','nikeshoes2.jpg');
insert into productTBL values 
('1002270','나이키','나이키신발2','270','60000','6','나이키슈즈2은, 평소에 데일리룩과 매칭이 잘어울리는 나이키 단화 입니다.','2022-10-26','38','nikeshoes2.jpg');
insert into productTBL values 
('1002280','나이키','나이키신발2','280','60000','6','나이키슈즈2은, 평소에 데일리룩과 매칭이 잘어울리는 나이키 단화 입니다.','2022-10-26','38','nikeshoes2.jpg');

insert into productTBL values 
('1003260','나이키','나이키신발3','260','70000','7','나이키슈즈3은, 특유의 물결라인과 잘 전체의 에어쿠셔닝으로 발의 편안함을 주는 운동화 입니다.','2022-10-26','45','nikeshoes3.jpg');
insert into productTBL values 
('1003270','나이키','나이키신발3','270','70000','7','나이키슈즈3은, 특유의 물결라인과 잘 전체의 에어쿠셔닝으로 발의 편안함을 주는 운동화 입니다.','2022-10-26','45','nikeshoes3.jpg');
insert into productTBL values 
('1003280','나이키','나이키신발3','280','70000','7','나이키슈즈3은, 특유의 물결라인과 잘 전체의 에어쿠셔닝으로 발의 편안함을 주는 운동화 입니다.','2022-10-26','45','nikeshoes3.jpg');

insert into productTBL values 
('1004260','나이키','나이키신발4','260','80000','8','나이키슈즈4은, 세가지 독특한 라인과 푹신한 에어쿠셔닝으로 스타일과 편안함을 한꺼번에 가질수 있는 신발 입니다.','2022-10-26','74','nikeshoes4.jpg');
insert into productTBL values 
('1004270','나이키','나이키신발4','270','80000','8','나이키슈즈4은, 세가지 독특한 라인과 푹신한 에어쿠셔닝으로 스타일과 편안함을 한꺼번에 가질수 있는 신발 입니다.','2022-10-26','74','nikeshoes4.jpg');
insert into productTBL values 
('1004280','나이키','나이키신발4','280','80000','8','나이키슈즈4은, 세가지 독특한 라인과 푹신한 에어쿠셔닝으로 스타일과 편안함을 한꺼번에 가질수 있는 신발 입니다.','2022-10-26','74','nikeshoes4.jpg');


-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`managerTBL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`managerTBL` (
  `manager_id` NVARCHAR(12) NOT NULL,
  `manger_pwd` NVARCHAR(12) NOT NULL,
  `manger_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`manager_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`user_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`user_board` (
  `post_no` INT NOT NULL,
  `member_code` INT NULL,
  `post_date` DATE NULL,
  `post_pwd` NVARCHAR(12) NULL,
  `post_subject` NVARCHAR(50) NULL,
  `post_text` TEXT NULL,
  `post_file` VARCHAR(300) NULL,
  PRIMARY KEY (`post_no`),
  INDEX `fk_user_board_memberTBL1_idx` (`member_code` ASC) VISIBLE,
  CONSTRAINT `fk_user_board_memberTBL1`
    FOREIGN KEY (`member_code`)
    REFERENCES `shoes_shoppingMall`.`memberTBL` (`member_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`cartTBL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`cartTBL` (
  `cart_id` INT NOT NULL,
  `member_code` INT NOT NULL,
  `product_no` INT NULL,
  `product_amount` INT NULL,
  PRIMARY KEY (`cart_id`),
  INDEX `fk_cart_product1_idx` (`product_no` ASC) VISIBLE,
  INDEX `fk_cartTBL_memberTBL1_idx` (`member_code` ASC) VISIBLE,
  CONSTRAINT `fk_cart_product1`
    FOREIGN KEY (`product_no`)
    REFERENCES `shoes_shoppingMall`.`productTBL` (`product_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cartTBL_memberTBL1`
    FOREIGN KEY (`member_code`)
    REFERENCES `shoes_shoppingMall`.`memberTBL` (`member_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

drop table cartTBL;
-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`orderTBL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`orderTBL` (
  `order_id` INT NOT NULL,
  `member_id` varchar(12) NOT NULL,
  `totalmoney` INT NOT NULL,
  `member_code` INT NULL,
  `order_date` DATE NULL,
  `order_status` VARCHAR(3) NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_orderTBL_memberTBL1_idx` (`member_code` ASC) VISIBLE,
  CONSTRAINT `fk_orderTBL_memberTBL1`
    FOREIGN KEY (`member_code`)
    REFERENCES `shoes_shoppingMall`.`memberTBL` (`member_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';

drop table orderTBL;

-- -----------------------------------------------------
-- Table `shoes_shoppingMall`.`order_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`order_detail` (
  `order_detail_id` INT NOT NULL,
  `order_id` INT NULL,
  `product_no` INT NULL,
  `order_amount` INT NULL,
  `order_price` INT NULL,
  PRIMARY KEY (`order_detail_id`),
  INDEX `fk_order_detail_order1_idx` (`order_id` ASC) VISIBLE,
  INDEX `fk_order_detail_product1_idx` (`product_no` ASC) VISIBLE,
  CONSTRAINT `fk_order_detail_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `shoes_shoppingMall`.`orderTBL` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_detail_product1`
    FOREIGN KEY (`product_no`)
    REFERENCES `shoes_shoppingMall`.`productTBL` (`product_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


/**************************************************************************************************/
select * from managerTbl;
select * from productTbl;
insert into managerTBL values ('admin123', 'admin123' ,'metalwing53@gmail.com');

CREATE TABLE IF NOT EXISTS `shoes_shoppingMall`.`memberTBL` (
  `member_code` INT NOT NULL,
  `member_id` NVARCHAR(12) NOT NULL,
  `member_pwd` NVARCHAR(12) NULL,
  `member_name` NVARCHAR(4) NULL,
  `member_birth` DATE NULL,
  `member_phone` VARCHAR(45) NULL,
  `member_email` VARCHAR(45) NULL,
  `member_gender` VARCHAR(45) NULL,
  PRIMARY KEY (`member_code`, `member_id`))
ENGINE = InnoDB;

insert into memberTBL values ('000000', 'user123' ,'user123' , 'user','1993-05-03','010-1111-2222','metalwing53@gmail.com','M');
select * from memberTBL;

select member_id from memberTBL where member_id='user123' and member_pwd='user123';

show tables;