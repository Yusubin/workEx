package pack02.subPack;

public class TV {
	

	int ch;
	int vol;
	boolean onOff;
	
	public String on(int time) {
		System.out.println(time+"시에 tv를 킴");
		
		return "OK";
	}
	
	public String toString() {	
		return ch+","+vol+","+onOff;
	}

}
