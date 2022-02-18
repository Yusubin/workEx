package pack03;

public class accountDAO {
	//create:계좌 생성
	public void create(accountVO accountVo) {
		System.out.println("계좌생성");
		System.out.println("vo에서 전달받은 값:"+accountVo);
		
		String name = accountVo.getName(); //이름
		String price = accountVo.getPrice();//금액
		String accountName = accountVo.getAccountName();//계좌이름
		
		System.out.println("이름:"+name);
		System.out.println("계좌이름:"+accountName);
		System.out.println("금액:"+price);
	}
	//login:계좌 로그인
	public void login(accountVO accountVo) {
		System.out.println("계좌 로그인");
	}
	//update:계좌업데이트
	public void update(accountVO accountVo) {
		System.out.println("계좌업데이트요청");
	}
	//delete:계좌 삭제
	public void delete(accountVO accountVo) {
		System.out.println("계좌 삭제");
	}
	
}
