package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDAO {
//	4가지 기능 수행 회원가입(create) 회원정보(read) 회원 정보 수정(Update) 회월 탈퇴(delete)
	//CRUD 크루드
	//DAO:Data Access Object 다오
	public void create(MemberVO memberVo) {
		System.out.println("vo에서 전달받은 값:"+memberVo);
		
		String id=memberVo.getId();
		String pw=memberVo.getPw();
		String name=memberVo.getName();
		String tel=memberVo.getTel();
		System.out.println("전달받은 id:"+id+"전달받은 pw:"+pw+"전달받은 name:"+name+"전달받은 tel:"+tel);
		
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/big";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="insert into member values (?, ?, ?,? )";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, tel);
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
	
	public boolean login(MemberVO memberVo) {
		
		String id=memberVo.getId();
		String pw=memberVo.getPw();
	
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/big";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="SELECT * FROM member where id=? and pw=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			System.out.println("3. SQL객체생성성공");
			boolean result=false; //없음 (
			//4. 생성한 sql문을 mysql로 보낸다. 
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("검색결과있음");
				result=true;
				return result;
			
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
		System.out.println("회원 로그인");
		return false;
	}
	public MemberVO readOne(MemberVO memberVo) {
		System.out.println("회원정보업데이트요청");
		System.out.println("vo에서 전달받은 값:"+memberVo);
		
		String id=memberVo.getId();
	
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/big";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="SELECT * from member where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. SQL객체생성성공");
			
			//4. 생성한 sql문을 mysql로 보낸다. 
			ResultSet rs= ps.executeQuery();
			
//			System.out.println("결과"+rs.next());
			MemberVO  vo1= new MemberVO();
			if(rs.next()) {
				String id1=rs.getString("id");
				String pw=rs.getString("pw");
				String tel=rs.getString("tel");
				String name=rs.getString("name");
				vo1.setId(id1);
				vo1.setName(name);
				vo1.setPw(pw);
				vo1.setTel(tel);

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
		return memberVo;
		
		
		
	}
	public ArrayList<MemberVO> readAll() {
		
		System.out.println("회원정보업데이트요청");
		
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/big";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="SELECT * from member";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL객체생성성공");
			
			//4. 생성한 sql문을 mysql로 보낸다. 
			ResultSet rs= ps.executeQuery();
		
			//가방들을 모을 저장공간을 만들어야함. 배열은 적합하지않음
			//MemberVO list = new MemberVO[]10()
			//가변적인 공간이 필요
			ArrayList<MemberVO> list = new ArrayList<>();
			
			
			while(rs.next()) {
				MemberVO  vo1= new MemberVO();
				String id1=rs.getString("id");
				String pw=rs.getString("pw");
				String tel=rs.getString("tel");
				String name=rs.getString("name");
				
				//가방에 넣음
				vo1.setId(id1);
				vo1.setName(name);
				vo1.setPw(pw);
				vo1.setTel(tel);
				
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
	public void update(MemberVO memberVo) {
		System.out.println("회원정보업데이트요청");
		System.out.println("vo에서 전달받은 값:"+memberVo);
		
		String id=memberVo.getId();
		String pw=memberVo.getPw();
		String name=memberVo.getName();
		String tel=memberVo.getTel();
		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/big";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="UPDATE member set tel=?  where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setString(2, id);
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
	public void delete(MemberVO memberVo) {
		System.out.println("회원정보 삭제");
		String id=memberVo.getId();

		try {
			//1. Connector 라이브러리 설정
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Connector 라이브러리 설정 성공 @@");
			//2. db 연결 승인된 사용자 (ip+port, user(root), pw db명(big)) 
			String url = "jdbc:mysql://localhost:3366/big";
			String user ="root";
			String pass = "1234";
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("2. db연결 성공 @@");
			//3. SQL생성
			String sql="DELETE FROM member  where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
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
