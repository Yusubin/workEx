package pack03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//db 프로그램 순서
		
		
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/big";
			String user ="root";
			String pw = "1234";
			Connection con=DriverManager.getConnection(url, user, pw);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="insert into member(id, pw, name) values (\"melon3\", \"1234\", \"melon song\")";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL객체생성성공");
			
			//4. 생성한 sql문을 mysql로 보낸다. 
			ps.executeUpdate();
			System.out.println("4. sql문을 mysql로 보낸다");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	
	
	}

}
