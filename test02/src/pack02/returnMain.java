package pack02;

import java.util.Date;

import test02.returnExercise;

public class returnMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        returnExercise re= new returnExercise();
        returnExercise re2= new returnExercise();
        
        System.out.println(re);
        
        //자바는 객체지향형 언어이므로 그기능을 담당하는 부품이 있어 그것을 사용하는데 주소가 필요
        //생성된 객체의 주소 특정한 기능을 사용하고싶으면 주소만 있으면 된다. 
        //반환이 없는경우에는 결과를 변수에 넣을수없.프린트할수덩ㅄ다
        re.add(100);
        double x1=re.add(22.1,1);
        int x2=re.add(22,100);
        String sum1=re.add("5",1);
        String sum2=re.add("dasd","asd");
//        System.out.println(x1);
//        System.out.println(x2);
//        System.out.println(sum1);
   
        System.out.println(sum2);
        int[] uu =re2.add();
        Date date2=re.add2();
        System.out.println(date2.getHours());
//      
//        for (int i = 0; i<uu.length; i++) {
//        	System.out.println( uu[i]);
//        }
	}

}
