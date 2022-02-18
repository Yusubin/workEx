package pack03;

public class accountVO {
	private String accountName;//계좌이름
	private String price;//금액
	private String name;//이름
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "accountVO [account_name=" + accountName + ", price=" + price + ", name=" + name + "]";
	}
}
