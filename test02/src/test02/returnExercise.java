package test02;

import java.util.Date;

public class returnExercise {
	
	public int add(int x, int y) {return x+y;}
	public double add(double x, int y) {return x+y;}
	public String add(String x, int y) {return x+y;}
	public String add(String x, String y) {return x+y;}
	public double add(double x, double y) {return x+y;}
	public void add(int x) {
		System.out.println(x+1+"입니다/");
	}
	public int[] add() {
		int[] x= {1,2,3};
		return x;
	}
	public Date add2() {
		Date date=new Date();
		return date;
	}
}
