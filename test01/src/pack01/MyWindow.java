package pack01;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame view = new JFrame();
		
		
//		JPanel jpane= new JPanel();
		
		JButton btn1 =new JButton();
		JButton btn2 =new JButton();
		
		btn1.setText("카카오 클롤링");
		btn1.setForeground(Color.red);
		btn1.setBackground(Color.yellow);
		view.add(btn1);

		view.setSize(500,500);
		view.setVisible(true);
	}

}
