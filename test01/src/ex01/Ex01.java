package ex01;

import javax.swing.JOptionPane;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1
		String a1 = JOptionPane.showInputDialog("숫자1 입력");
		String a2 = JOptionPane.showInputDialog("숫자2 입력");
		int a=Integer.parseInt(a1);
		int b=Integer.parseInt(a2);
		if(a==b) {
			JOptionPane.showMessageDialog(null, "동일해요");
			
		}else {
			JOptionPane.showMessageDialog(null, "달라요");
		}
		
		
	
	}

}
