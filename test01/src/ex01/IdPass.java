package ex01;

import javax.swing.JOptionPane;

public class IdPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = JOptionPane.showInputDialog("아이디 입력");
		String pass = JOptionPane.showInputDialog("비밀번호 입력");
		if(id.equals("root")&&pass.equals("1234")) {
			JOptionPane.showMessageDialog(null, "로그인 성공");
					
		}else {
			JOptionPane.showMessageDialog(null, "로그인 실패!");
		}
	}

}
