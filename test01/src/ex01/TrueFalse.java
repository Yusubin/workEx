package ex01;

import javax.swing.JOptionPane;

public class TrueFalse {
	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("아이디 입력");

		if(id.equals("root")) {
			JOptionPane.showMessageDialog(null, "맞아요");
					
		}else {
			JOptionPane.showMessageDialog(null, "틀려요");
		}
	}
}
