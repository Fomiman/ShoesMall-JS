package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public OrderTBL selectLatestOrder(String member_id) {
		OrderTBL latestOrder = null;
		
		String sql = "select * from orderTBL where member_id=? order by order_date desc limit 1";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				latestOrder = new OrderTBL(rs.getInt("order_id"),
											rs.getString("member_id"),
											rs.getInt("totalmoney"),
											rs.getInt("member_code"),
											rs.getDate("order_date"),
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

	public ArrayList<OrderTBL> selectMyOrderList(String member_id) {
		ArrayList<OrderTBL> myOrderList = null;
		
		String sql = "select *from orderTBL where member_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);	
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				myOrderList = new ArrayList<OrderTBL>();
				
				do {
					myOrderList.add(new OrderTBL (rs.getInt("order_id"),
											rs.getString("member_id"),
											rs.getInt("totalmoney"),
											rs.getInt("member_code"),
											rs.getDate("order_date"),
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


	public ArrayList<Order_detail> selectMyOrderDetailList(int order_id) {
		ArrayList<Order_detail> myOrderDetailList = null;
		return null;
	}

}
