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
	
	public int write(int stubun) {
		int row = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "insert into table_01 values("+stubun+",?,?,?,?)";
		DTO vo = new DTO();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getStuname());
			pstmt.setString(2, vo.getStuaddr());
			pstmt.setString(3, vo.getStuphone());
			pstmt.setString(4, vo.getStubirth());
				
			if(stubun != vo.getStubun()) {
				System.out.println(stubun);
				pstmt.setInt(stubun, vo.getStubun());
				row = pstmt.executeUpdate();	
				System.out.println(row);
			}else {
				row = 0;
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
		return row;
	}
	
}
