package pack03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
			String sql="insert into member values (?, ?, ?,?)";
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
	
	public void login(MemberVO memberVo) {
		
		System.out.println("회원 로그인");
	}
	public void read(MemberVO memberVo) {
		
		System.out.println("회원읽기");
	}
	public void update(MemberVO memberVo) {
		System.out.println("회원정보업데이트요청");
	}
	public void delete(MemberVO memberVo) {System.out.println("회원정보 삭제");}
	
	
}
