package pack03;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class BasicProcess1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
		String age = JOptionPane.showInputDialog("나이를 입력");
		int a=Integer.parseInt(age);
		System.out.println(a);
		JOptionPane.showMessageDialog(null, "내년나이는"+(a+1));
	}

}
