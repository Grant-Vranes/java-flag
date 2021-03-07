package Y2021M2D22;

//null和引用类型划等号演示
public class NullRefDemo {
	public static void main(String[] args) {
		Student zs = new Student("zs",19,"Arka");
		System.out.println(zs.age);
		zs = null;//空，没有指向任何对象
		//System.out.println(zs.age);//NullPointerException
	
		Student ls = new Student("ls",19,"kroka");
		Student lss = ls;//指向同一个对象
		lss.age = 45;
		System.out.println(ls.age);//45
		
		int a = 5;
		int b = 6;
		a = b;
		System.out.println(a);
		
	}
}
