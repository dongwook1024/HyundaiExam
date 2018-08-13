package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.study.model.Member;

public class MemberDao {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "shopmall";
	private static final String PW = "1111";
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			return DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean insertMember(Member member) {
		
		Connection conn = getConnection();
		
		PreparedStatement ps = null;
		
		if (conn != null && member != null) {
			
			String sql = "INSERT INTO MEMBER (ID, NAME, PW, DOB, EMAIL) "
					+ " VALUES (?, ?, ?, ?, ?)";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, member.getId());
				
				ps.setString(2, member.getName());
				
				ps.setString(3, member.getPw());
				
				ps.setDate(4, member.getDob());
				
				ps.setString(5, member.getEmail());
				
				int result = ps.executeUpdate();
				
				if (result == 0) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public Member[] listMember() {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		if (conn != null) {
			String sql = "select id, name, dob, email from member";
			try {
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				ArrayList<Member> list = new ArrayList<>();
				while (rs.next()) {
					Member member = new Member();
					member.setId(rs.getString(1));
					member.setName(rs.getString(2));
					member.setDob(rs.getDate(3));
					member.setEmail(rs.getString(4));
					
					list.add(member);
				}
				
				return list.toArray(new Member[0]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
