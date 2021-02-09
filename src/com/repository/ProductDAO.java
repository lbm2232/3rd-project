package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.MemberDTO;
import com.model.ProductDTO;

public class ProductDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	
	MemberDTO info = null;
	ResultSet rs = null;

	public void conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://121.179.7.111:3306/pfdb?serverTimezone=UTC";
			String db_id = "bom";
			String db_pw = "bom";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			System.out.println("연결됨");
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

	public ArrayList<ProductDTO> All() {
		conn();
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		try {
			String sql = "select * from product";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {//rs.next()는 커서를 다음으로 옮기는 것을 의미한다.
								//그러므로 rs의 결과 값이 null인지 확인하고, null이 아닐 경우 while문을 수행한다.
				int product_num = rs.getInt(1);
				String product_name = rs.getString(2);
				String product_img = rs.getString(3);
				int Categry_num = rs.getInt(4);
				ProductDTO item = new ProductDTO(product_num, product_name, product_img, Categry_num);
				list.add(item);//list에 item추가
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void put_product(ProductDTO dto) {
		conn();
		try {
			String sql = "insert into product values (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getProduct_num());
			psmt.setString(2, dto.getProduct_name());
			psmt.setString(3, dto.getProduct_img());
			psmt.setInt(4, dto.getCategry_num());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public ArrayList<ProductDTO> select_by_name(String keyword, String category) {

		conn();
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		try {
			String sql = "select * from (" + 
					"select * from product p, category c where p.category_categry_num=c.categry_num " + 
					") a  where product_name like ? and catergry_name like ?";
			// "select * from product where product_name like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, '%'+ keyword + '%');
			psmt.setString(2, '%' + category + '%');
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				int product_num = rs.getInt(1);
				String product_name = rs.getString(2);
				String product_img = rs.getString(3);
				int Categry_num = rs.getInt(4);
				
				ProductDTO item = new ProductDTO(product_num, product_name, product_img, Categry_num);
				list.add(item);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	
	
}
