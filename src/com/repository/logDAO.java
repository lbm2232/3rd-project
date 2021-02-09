package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.MemberDTO;
import com.model.ProductDTO;
import com.model.logDTO;

public class logDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	MemberDTO info = null;
	ResultSet rs = null;
	logDTO log = null;

	public void conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://121.179.7.111:3306/pfdb?serverTimezone=UTC";
			String db_id = "bom";
			String db_pw = "bom";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			System.out.println("¿¬°áµÊ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<logDTO> select(int num) { 
		conn();
		ArrayList<logDTO> list = new ArrayList<logDTO>();
		try {
			String sql = "select * from product where product_num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int product_num = rs.getInt(1);
				String product_name = rs.getString(2);

				log = new logDTO(product_num, product_name);
				list.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public void insert_log(logDTO dto) { //int

		try {
			conn();
			
			String sql = "insert into log values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getCount());
			psmt.setInt(2, dto.getMember_num());
			psmt.setInt(3, dto.getProduct_num());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	
	public logDTO logcheck(logDTO dto){
		logDTO check = null;
		//ArrayList<logDTO> list = new ArrayList<logDTO>();
		try {
			conn();
			String sql = "select * from log where member_member_num = ? and product_product_num = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getMember_num());
			psmt.setInt(2, dto.getProduct_num());
			rs = psmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				int member_num = rs.getInt(2);
				int product_num = rs.getInt(3);
				check = new logDTO( count, product_num, member_num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return check;
	}
	public int logupdate(logDTO dto) {
		conn();
		try {
		String sql = "update log set count = count+1 where member_member_num =? and product_product_num = ? ";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, dto.getMember_num());
		psmt.setInt(2, dto.getProduct_num());
		cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
		
		
	}
}
