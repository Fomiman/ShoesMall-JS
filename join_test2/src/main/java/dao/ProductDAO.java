package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.OrderTBL;
import vo.ProductTBL;

public class ProductDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	private ProductDAO() {}
	
	private static ProductDAO productDAO;
	
	public static ProductDAO getInstance() {
		
		if(productDAO == null) {
			productDAO = new ProductDAO();
		}
		
		return productDAO;
	}

	public void setConnection(Connection con) {
			this.con=con;
	}
	
	//모든 신발 목록 조회
	public ArrayList<ProductTBL> selectProductList() {
			
		ArrayList<ProductTBL> productList = null;
		String sql = "select * from productTBL";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				productList = new ArrayList<ProductTBL>();
				
				do {
					ProductTBL productTBL = new ProductTBL(
							rs.getInt("product_no"),
							rs.getString("category_code"),
							rs.getString("product_name"),
							rs.getInt("product_size"),
							rs.getInt("product_price"),
							rs.getInt("product_amount"),
							rs.getString("product_decs"),
							rs.getString("product_date"),
							rs.getInt("product_hits"),
							rs.getString("product_image")
							);
					productList.add(productTBL);
						
				}while (rs.next());
			}
		}catch (SQLException e) {
			 System.out.println("selectProductTBLList()에러 :" + e );
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return productList;
	}
	
	//product_no에 해당하는 특정 신발 상품 정보 객체로 변환
	public ProductTBL selectProductView(int product_no) {
		ProductTBL productView =null;
		
		String sql = "select * from productTBL where product_no=?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, product_no);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						productView = new ProductTBL (
								rs.getInt("product_no"),
								rs.getString("category_code"),
								rs.getString("product_name"),
								rs.getInt("product_size"),
								rs.getInt("product_price"),
								rs.getInt("product_amount"),
								rs.getString("product_decs"),
								rs.getString("product_date"),
								rs.getInt("product_hits"),
								rs.getString("product_image")
							
								);
					}
				}catch (SQLException e) {
					System.out.println("selectProductView()에러 : "+e);
				}finally {
					close(rs);
					close(pstmt);
				}
				
		return productView;
	}
	
	public int insertProduct(ProductTBL productTBL) {
		int insertCount = 0;
		
		String sql = "insert into productTBL values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productTBL.getProduct_no());
			pstmt.setString(2, productTBL.getCategory_code());
			pstmt.setString(3, productTBL.getProduct_name());
			pstmt.setInt(4, productTBL.getProduct_size());
			pstmt.setInt(5, productTBL.getProduct_price());
			pstmt.setInt(6, productTBL.getProduct_amount());
			pstmt.setString(7, productTBL.getProduct_decs());
			pstmt.setString(8, productTBL.getProduct_date());
			pstmt.setInt(9, productTBL.getProduct_hits());
			pstmt.setString(10, productTBL.getProduct_image());
			insertCount = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("insertProduct() :" + e);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public int updateReadCount(int product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 매출관리 페이지 전체 주문 조회( 매출액, 주문일 포함)
	// 주문 승인 기능 완성 시 orderTBL 테이블에 order_status의 값이 1인 주문(주문승인상태)만 불러올 수 있도록 만들어야 함
	public ArrayList<OrderTBL> getTotalOrderList() {
		
		String sql = "select order_id, product_no, order_amount, order_price, order_date from ordertbl natural join order_detail";
		ArrayList<OrderTBL> totalOrderList = new ArrayList<OrderTBL>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderTBL ot = new OrderTBL(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5)
						);
				totalOrderList.add(ot);
			}
		} catch (SQLException e) {
			System.out.println("[ProductDAO] getTotalOrderList() 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return totalOrderList;
	}


}
