package web;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class memberView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String id = JOptionPane.showInputDialog("ID를 입력");
		String pw = JOptionPane.showInputDialog("pw를 입력");
		String name = JOptionPane.showInputDialog("name를 입력");
		String tel = JOptionPane.showInputDialog("tel를 입력");
		
		//제어부분. 가방만들어서 입력데이터를 넣음
		
		MemberVO memVo=new MemberVO();
		memVo.setId(id);
		memVo.setPw(pw);
		memVo.setName(name);
		memVo.setTel(tel);
		//db에 넣는 처리. DAP에게 가방넣어서 전달
		
		MemberDAO memDao=new MemberDAO();
		
		memDao.create(memVo);
	}

}
