package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	private DAO() {}
	private static DAO instance = new DAO();
	public static DAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	
	public int write(DTO vo) {
		int row = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "insert into table_01 values("+vo.getStubun()+",?,?,?,?)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getStuname());
			pstmt.setString(2, vo.getStuaddr());
			pstmt.setString(3, vo.getStuphone());
			pstmt.setString(4, vo.getStubirth());
				
//			if(stubun != vo.getStubun()) {
//				System.out.println(stubun);
//				pstmt.setInt(stubun, vo.getStubun());
//				row = pstmt.executeUpdate();	
//				System.out.println(row);
//			}else {
//				row = 0;
//			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	//수정 번호 검색
	public DTO search(int stubun) {
		DTO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="select * from table_01 where stubun="+stubun;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new DTO();
				vo.setStubun(rs.getInt("stubun"));
				vo.setStuname(rs.getString("stuname"));
				vo.setStuaddr(rs.getString("stuaddr"));
				vo.setStuphone(rs.getString("stuphone"));
				vo.setStubirth(rs.getString("stubirth"));			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	//수정
	public int update(DTO vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query="update table_01 set stubun=?, stuname=?, stuaddr=?, stuphone=?, stubirth=?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, vo.getStubun());
			pstmt.setString(2, vo.getStuname());
			pstmt.setString(3, vo.getStuaddr());
			pstmt.setString(4, vo.getStuphone());
			pstmt.setString(5, vo.getStubirth());
			row = pstmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//성적 리스트
	public DTO grade_list(int stubun) {
		DTO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="select * from table_01 where stubun="+stubun;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new DTO();
				vo.setStubun(rs.getInt("stubun"));
				vo.setStuname(rs.getString("stuname"));
				vo.setStuaddr(rs.getString("stuaddr"));
				vo.setStuphone(rs.getString("stuphone"));
				vo.setStubirth(rs.getString("stubirth"));			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
}
