package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.MemberDTO;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	MemberDTO info = null;
	ResultSet rs = null;

	public void conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://121.179.7.111:3306/new?serverTimezone=UTC";
			String db_id = "root";
			String db_pw = "1225";
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
	
	public int join(MemberDTO dto) {

		try {
			conn();
			String sql = "insert into member values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 2);
			psmt.setString(2, dto.getMember_pw());
			psmt.setString(3, dto.getMember_pw());
			

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public MemberDTO login(MemberDTO dto) {

		try {
			conn();
			String sql = "select * from member where member_id = ? and member_pw = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getMember_id());
			psmt.setString(2, dto.getMember_pw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				String member_id = rs.getString(1);
				String member_pw = rs.getString(2);

				info = new MemberDTO(member_id, member_pw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return info;
	}


}


	

