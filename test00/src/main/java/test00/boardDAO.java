package test00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class boardDAO {
	public void create(boardVO vo) {
		System.out.println("vo에서 전달받은 값:"+vo);
		
		String title=vo.getTitle();
		String content=vo.getContent();
		String name=vo.getName();
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/board";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="insert into board(title,name,content) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setString(3, content);

			System.out.println("3. SQL객체생성성공");
			
//			4. 생성한 sql문을 mysql로 보낸다. 
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
	public void update(boardVO vo) {
		String title=vo.getTitle();
		String content=vo.getContent();
		int idx=vo.getIdx();
//		System.out.println("전달받은 id:"+id+"전달받은 pw:"+pw+"전달받은 name:"+name+"전달받은 tel:"+tel);
		
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/board";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="UPDATE board set title= ?, content= ? where idx=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, idx);

			System.out.println("3. SQL객체생성성공");
			
//			4. 생성한 sql문을 mysql로 보낸다. 
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

	public void delete(boardVO vo) {
		int idx=vo.getIdx();
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/board";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="DELETE from board where idx=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			
			System.out.println("3. SQL객체생성성공");
			
//			4. 생성한 sql문을 mysql로 보낸다. 
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
	public boardVO readOne(boardVO vo) {
		System.out.println("회원정보readOne");
		System.out.println("vo에서 전달받은 값:"+vo);
		
		String name=vo.getName();
	
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/board";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="SELECT * from board where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			System.out.println("3. SQL객체생성성공");
			
			//4. 생성한 sql문을 mysql로 보낸다. 
			ResultSet rs= ps.executeQuery();
			
//			System.out.println("결과"+rs.next());
			boardVO  vo1= new boardVO();
			if(rs.next()) {
				String name1=rs.getString("name");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Timestamp rgstday=rs.getTimestamp("rgstday");
				vo1.setTitle(title);
				vo1.setName(name1);
				vo1.setContent(content);
				vo1.setRgstday(rgstday);

				return vo1;
			
			}else {
				System.out.println("검색결과없음");
			}
			System.out.println("4. sql문을 mysql로 보낸다");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
		
		
		
	}
	public ArrayList<boardVO> readAll() {
		
		System.out.println("회원정보readAll");
		
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/board";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="SELECT * from board";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL객체생성성공");
			
			//4. 생성한 sql문을 mysql로 보낸다. 
			ResultSet rs= ps.executeQuery();
		
			//가방들을 모을 저장공간을 만들어야함. 배열은 적합하지않음
			//MemberVO list = new MemberVO[]10()
			//가변적인 공간이 필요
			ArrayList<boardVO> list = new ArrayList<>();
			
			
			while(rs.next()) {
				boardVO  vo1= new boardVO();
				String name=rs.getString("name");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Timestamp rgstday=rs.getTimestamp("rgstday");
				vo1.setTitle(title);
				vo1.setName(name);
				vo1.setContent(content);
				vo1.setRgstday(rgstday);
				
				
				list.add(vo1);
				
			}
			System.out.println("4. sql문을 mysql로 보낸다");
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	

		
		
		
		
	}
}
	
