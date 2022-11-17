# 페이지 예시 (추가 예정)  
-
-
-
-
# 작업 로그

## ver1.0.4
 - 스타일 수정

## ver1.0.3

 - 품절 시 회원의 상품목록 및 상품상세 페이지에서 품절 표시 및 장바구니 버튼 제거

## ver0.1.0.2

 상단 바 스타일 변경

## ver0.1.0.1

 상품페이지 ~ 구매정보 페이지 + 로그인 페이지 스타일 수정
 
## ver1.0.0
 첫번째 최종본


### ver0.1.0.2

 상단 바 스타일 변경

### ver0.1.0.1

 상품페이지 ~ 구매정보 페이지 + 로그인 페이지 스타일 수정
 


## ver0.0.9

 - 페이징 작업 완료 목록(유저의 상품목록, 유저게시판, 관리자-유저게시판, 실시간 주문조회, 상품 목록
 - 상품페이지 표시 변경
 - 상품 수정/삭제 기능 추가
 - 매출관리 페이지 선택 년도와 월로 월 매출 조회 가능
 - 상품 상세 페이지 사진선택 하지 않을 시 기존의 사진 파일명 그대로 유지되게 적용


## ver0.0.8 업데이트 내역 및 추후 추가 필요한 사항
(order.jsp 페이지 주문하기 버튼 삭제 및 페이지 하단영역에 구매자 정보 불러와서 표기 하기 + 하단에 푸터 회색으로 뜨는거 고치기, 주문하기 ~ 구매 페이지 까지 반응형웹 적용시키기 )

-- 관리자의 회원탈퇴 기능 추가(deleteUserAccount.mgr)
-- 공지사항 삭제 기능 (deleteNotice.mgr)

-- 주문 승인/취소 기능 추가(updateOrder.mgr, canselOrder.mgr)
-- 매출 조회 시 승인된 주문만 보이도록 변경(완)

-- 각 조회 페이지 및 게시판 페이지에 페이징 작업(진행중)
	-실시간 매출조회 showList()에 매개변수 pageNum 추가(OrderManagementAction 부터 받아온 값으로 메서드까지 이어짐)
	-유저 페이지 상품 리스트(유저페이지, 관리자페이지 다름)
	-게시판
	-공지사항
	-
	
-- 상품페이지 등록순/가격순 정렬 추가하기(+가격대로 검색 기능)
-- 제품수정/삭제 (예정)	


## ver0.0.7 (2022-11-07)

조회수 증가 메서드 추가 필요

ProductFrontController 내 action내 orderTBL에 연결 되는 값들 중 member_id로 연결되는 값들 member_code로 변경함

장바구니 담기 ~ 구매하기 액션까지 추가 완료 (장바구니에서 구매하기 누를때 바로 구매정보 insert)


## ver0.0.6 (2022-11-06~)
 
 회원탈퇴 기능 추가 (member_code로 얽혀있는 데이터들 모두 ON DELETE CASCADE 설정 되어있어서 memberTBL에서만 지워지도록 설정함)
 
 ## ver0.0.5 까지의 작업 내역 (미작성된 로그 다수) 
 ### 22-11-06
 
 --매출 관리 월별 조회 기능 추가
 
 15:04 삭제기능 추가 시작 
 -작업 순서 
  (유저)1.유저게시판 - 2.회원탈퇴
  (관리자) 3.공지사항 - 4.회원탈퇴 - 5.상품삭제 - 6.유저게시판 
  
 1.(완료)
 2.(진행중)
 
 -- 데이터베이스명 ipc22jsk로 변경함 
 -- 워크벤치내 데이터베이스명 및 테이블 내용 수정사항 있음( on delete no action -> cascade)
 
###  22-11-05
 
 -- 상품리스트 페이지 반응형 맞게 일단 맞춰둠( mainTemplate.jsp 페이지에서 @media 속성으로 어거지로 맞춰둠 추후에 수정 필요)

###  22-11-04
 
 오늘 할거
 -매출 관리 페이지 만들기 (완)
 - 삭제 기능 만들기
 	(상품, 회원, 공지, 게시물)
 - 관리자의 유저게시판 접근 (완)
 
 고려사항
 - 리플 기능
 - 
 
 ※ 진행사항
 매출관리 페이지 월별 조회 가능하도록 만들어야함
 
 ※ 추가된 것(주환이형거 받아서 합친거 포함)
 - 나이키 상품목록 보기
 - 상품 상세 페이지
 - 장바구니 담기(회원 네비게이션에 장바구니 항목 추가)
  
 ★☆※ 주말에 할거 
 -- 매출 관리 월별 조회 기능 추가하기
 -- 각 게시판 및 상품 삭제 기능 추가하기
 
 
###  22-11-03
 
 -- ※ 상품목록&제품상세 추가 완료
 
 추가할 것들 
 - 상품 등록 -- 완료(사진 등록 및 상품목록에서 이미지 썸네일로 불러오기 추가)
 - 매출 관리 
 - 상품, 회원, 게시물, 공지 삭제 기능 추가하기
 
###  22-11-02
 
 --회원관리 페이지 회원목록 불러오기 완료
 -- 회원 정보 수정 페이지 만드는 작업 시작(회원 마이페이지 jsp 파일 가져와서 불러오는 액션 변경으로 가능)
 
 --회원 관리 페이지에 사용하기 위해 MemberTBL.java 파일에 address1~3까지 변수 추가함
 
 --회원 마이페이지에서 사용하는 회원 정보 수정용 Service들 이용하여 회원 정보 상단과 하단의 주소 각각 수정 가능하도록 만듦(완성)
 
 (수정 필요한것) 
 --공지사항 등록 실패 발생, 공지 상세보기 작동 오류
 
 (수정완료)
 -- 공지사랑 등록, 공지 상세보기
 
 (추가 필요)
 --상품목록&제품상세
 --상품등록
 
### ### 22-10-31
 
 (추가중) 아이디 중복체크 idCheck 폴더 내 jsp파일 2개
 (완료) 아이디 중복체크(value값 설정 안되는 건 name='member_id'만 주고 id='member_id'를 안줘서 function에서 인식을 못한것 
 

### 22-10-30
(추가 해야될 기능 - 추가 완료시 표기할것)
--orderTBL 테이블에 총 가격 넣어서 불러올때 order_detail테이블과 조인하여 총 가격 불러올수 있게 수정해야함
--장바구니 주문하기 시에 sql문에서 제품 가격*수량 으로 주문 시 가격 맞춰서 order_detail테이블에 넣어줘야함
 
 -- 유저의 고객센터 및 공지사항 보기 기능 완료
 


### 22-10-29
--유저 마이페이지 + 유저 주소 등록 처리 완성(가입시 주소 null로 만들어 생성되도록 만듬)
-- 유저 마이페이지에서 회원 정보와 주소 등록/변경 가능하도록 만듬(null처리 JSP페이지에서 처리) - 완성


### 22-10-28
작업예정 : (관리자용 기본적인 페이지들 jsp 파일 사용자거 복사해와서 이름 바꾸고 컨트롤러에 이동 방식 추가하기)
-- 관리자 로그인 여부에 따라 관리 목록보이기
-- 관리자 로그인 (아이디 저장 기능 X)
-- 공지사항 등록하기 (옆에 문의내역은 나중에 만들기)
-- 공지사항용 테이블(noticeBoardTBL) 추가
 
-- ※유저 문의하기 삭제
-- 관리자 네비 각페이지 드롭다운으로 분리(한 페이지에 두종류 관리 넣기 힘들고 복잡하여 일단 패스)
 
-- ※ managerTBL 컬럼명 mangr 로 되어있던것 변경함 + 유저이름 nvarchr(4)에서 varchar(12)로 변경

#### 작업 완료 목록
--관리자 로그인 + 로그인 시 목록 변경

### 22-10-27
(사용자 페이지)
--완료 목록 : 게시판 보기, 게시글 보기, 글쓰기, 로그인, 로그아웃, 아이디 저장 
--만들어야 하는것 : 상품란, 상품 상세 페이지, 상품 필터, 회원 마이페이지(주소 따로 입력), 장바구니, 주문하기

(관리자 페이지)
--사용자 페이지에서 가져와서 서식부터 맞추기(사용자 페이지 우선적으로 만들기)


### 2022-10-23
-인덱스 페이지에서 사용자/관리자 페이지 이동 구분 및 서블릿으로 이동 처리
-sql파일 추가 현재 9개 테이블 생성
| carttbl                      |
| deliver_address              |
| managertbl                   |
| membertbl                    |
| order_detail                 |
| ordertbl                     |
| product_category             |
| producttbl                   |
| user_board				   |
-userRightTopDiv.jsp에 로그인 상태에 따라 로그인/로그아웃 버튼 전환되도록 jstl로 처리함
-로그인 버튼 누르면 loginForm.jsp로 이동
-DTO추가(vo폴더내 actionforward 제외한것들)


--★★로그인 기능 구현 성공 (context.xml에 서버 연동하는거 바꿔주기 + 테이블 이름 제대로 되어있나 잘 확인할것!)
-- 로그아웃 구현 완료

///////////////////////////////////////////////////////////2022-10-24

-- 프로젝트 합치기
-- 각 페이지 별로 동일하게 들어가있는 네비게이션 파트 따로 분리(완료)
		<%
			String member_id = null;
			if(session.getAttribute("member_id")!= null){
				member_id = (String) session.getAttribute("member_id");
			}
		
		%>
		--이 부분(이후 'member_id세팅'이라고 칭함) 을 네비게이션 파트에 넣어두기 때문에 기존 페이지에 있던 동일한 부분은 제거함 
		--( include가 <% %> 구문 보다 위에 있다면 'member_id세팅' 구문이 아래에서 필요한 페이지)

-- 페이지명 필요에 의해 수정 (파일명 변경보단 새로 include용 페이지 만드는 것이 더 나아보임
-- jsp파일 내 input name 테이블(DTO)에 맞게 수정








 
 
 
 
