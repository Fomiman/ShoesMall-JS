package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.OrderTBL;
import vo.Order_detail;

public class OrderDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private OrderDAO() {}
	
	private static OrderDAO orderDAO;

	public static OrderDAO getInstance() {
		if(orderDAO == null) {
			orderDAO = new OrderDAO();
		}
		return orderDAO;
	}

	public void setConnection(Connection con) {
		this.con=con;
	}

	public OrderTBL selectLatestOrder(String member_code) {
		OrderTBL latestOrder = null;
		
		String sql = "select * from orderTBL where member_code=? order by order_date desc limit 1";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				latestOrder = new OrderTBL(rs.getInt("order_id"),
											rs.getInt("member_code"),
											rs.getInt("totalmoney"),
											rs.getString("order_date"),
											rs.getString("order_status")
						);
			}
		}catch (Exception e) {
			System.out.println("selectLatestOrder 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);	
		}
		return latestOrder;
	}

	public ArrayList<OrderTBL> selectMyOrderList(String member_code) {
		ArrayList<OrderTBL> myOrderList = null;
		
		String sql = "select *from orderTBL where member_code=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_code);	
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				myOrderList = new ArrayList<OrderTBL>();
				
				do {
					myOrderList.add(new OrderTBL (	rs.getInt("order_id"),
													rs.getInt("member_code"),
													rs.getInt("totalmoney"),
													rs.getString("order_date"),
													rs.getString("order_status"))
							
							);
				}while (rs.next());
			}
		}catch (Exception e) {
			System.out.println("selectMyOrderList 에러 : " + e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return myOrderList;
	}

	// 현재 사용자의 주문 내역 불러오기
	public ArrayList<Order_detail> selectMyOrderDetailList(int order_id) {
		ArrayList<Order_detail> myOrderDetailList = null;
		return null;
	}
	// 실시간 주문관리 - 주문 승인 버튼 메서드
	public boolean updateOrderStatus(int order_id) {
		boolean updateSuccess = false;
		String sql = "update orderTBL set order_status = 1 where order_id ="+order_id;
		
		try {
			pstmt = con.prepareStatement(sql);
			int updateStatus = pstmt.executeUpdate();
			
			if(updateStatus>0) {
				updateSuccess = true;
			}else {
				System.out.println("주문 승인 실패");
			}
			
		} catch (SQLException e) {
			System.out.println("updateOrderStatus 메서드 에러"+e);
		}finally {
			close(pstmt);
		}
		
		return updateSuccess;
	}
	
	// 주문 승인 시 재고 감소 메서드
		public int ProductAmountDecrease(String[] product_no, String[] order_amount) {
			// 제품 갯수(product_no의 길이만큼의 반복횟수)만큼 정상적으로 실행되었는지 확인하기위한 변수
			int decreaseSuccess = 0;
			
				try {
					for(int i =0 ; i<product_no.length; i++) { // 들어있는 제품의 종류 수 만큼 반복시킨다.
						String sql = "update productTBL set product_amount = product_amount-"+order_amount[i]+" where product_no="+product_no[i];
							
						pstmt = con.prepareStatement(sql);
						int updateStatus = pstmt.executeUpdate();
						
						if(updateStatus>0) {
							decreaseSuccess ++;
						}else {
							System.out.println("재고 수량 감소 실패");
						}
					}
					
				} catch (SQLException e) {
					System.out.println("ProductAmountDecrease 메서드 에러"+e);
				} finally {
					close(pstmt);
				}
			
			return decreaseSuccess;
		}
		//주문 승인상태에서 취소 시 감소한 수량만큼 다시 증가 시키는 메서드 
		public int ProductAmountIncrease(String[] product_no, String[] order_amount) {
			// 제품 갯수(product_no의 길이만큼의 반복횟수)만큼 정상적으로 실행되었는지 확인하기위한 변수
			int increaseSuccess = 0;
			
				try {
					for(int i =0 ; i<product_no.length; i++) { // 들어있는 제품의 종류 수 만큼 반복시킨다.
						String sql = "update productTBL set product_amount = product_amount+"+order_amount[i]+" where product_no="+product_no[i];
							
						pstmt = con.prepareStatement(sql);
						int updateStatus = pstmt.executeUpdate();
						
						if(updateStatus>0) {
							increaseSuccess ++;
						}else {
							System.out.println("재고 수량 증가 실패");
						}
					}
					
				} catch (SQLException e) {
					System.out.println("ProductAmountIncrease 메서드 에러"+e);
				} finally {
					close(pstmt);
				}
			
			return increaseSuccess;
		}
		
	// 실시간 주문관리 - 주문 취소 버튼 메서드
	public boolean cancelOrderStatus(int order_id) {
		boolean cancelSuccess = false;
		String sql = "update orderTBL set order_status = 2 where order_id ="+order_id;
		
		try {
			pstmt = con.prepareStatement(sql);
			int cancelStatus = pstmt.executeUpdate();
			
			if(cancelStatus>0) {
				cancelSuccess = true;
			}else {
				System.out.println("주문 취소 실패");
			}
			
		} catch (SQLException e) {
			System.out.println("cancelOrderStatus 메서드 에러"+e);
		}finally {
			close(pstmt);
		}
		
		return cancelSuccess;
	}

	

}
