package pack03;

import javax.swing.JOptionPane;

public class accountView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog("이름 입력");
		String price = JOptionPane.showInputDialog("금액를 입력");
		String account_name = JOptionPane.showInputDialog("은행계좌이름을 입력");


		
		//제어부분. 가방만들어서 입력데이터를 넣음
		accountVO vo = new accountVO();
		vo.setAccountName(account_name);
		vo.setPrice(price);
		vo.setName(name);
		
		//db에 넣는 처리. DAO에게 가방넣어서 전달
		
		accountDAO acDao=new accountDAO();
		
		acDao.create(vo);
	}

}
