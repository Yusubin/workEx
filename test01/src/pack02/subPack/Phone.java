package pack02.subPack;

public class Phone {
	
	String color;
	int size=0;
	
	int price =0;
	
	public void tel(String number) {
		System.out.println(number+"로 전화중");
	}
	public void kaka(String name) {
		System.out.println(name+"과 카톡중");
	}
	
	@Override
	public String toString() {
		return "Phone [color=" + color + ", size=" + size + ", price=" + price + "]";
	}
//	
//	String myNumber;//변수의 자동초기화
//	String yourNumber;
//	boolean call;
//	boolean onOff;
//	
//	public String call(String myNumber) {
//		yourNumber="01010101";
//		System.out.println(myNumber+"이"+yourNumber+"로 전화중");
////		System.out.println(myNumber+"가 전화중");
//		
//		return "calling";
//	}
//	public String call(String myNumber,String yourNumber) {
//		System.out.println(myNumber+"이"+yourNumber+"로 전화중");
//		return "calling";
//	}
//	public String toString() {	
//		return "내 폰번호:"+myNumber+"상대방 폰번호:"+yourNumber+","+onOff;
//	}

}
