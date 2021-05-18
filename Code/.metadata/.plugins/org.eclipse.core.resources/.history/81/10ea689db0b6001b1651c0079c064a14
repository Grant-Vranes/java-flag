package Y2021M5D16_Reflect;
/**
 * 	JDK5之后推出了一个新的特性:
 * 	可变参数
 * 	注意：可变参数在同一个方法中只能出现一次并且是在参数列表的末尾
 * @author Grant·Vranes
 *
 */
public class ArgDemo {
	public static void main(String[] args) {
		dosome("a"); //1
		dosome("a","b");//2
		dosome("a","b","c");//3
		/*
		 * 	实质上
		 * 	dosome(new String[]{"a"});
		 * 	dosome(new String[]{"a","b"});
		 * 	dosome(new String[]{"a","b","c"});
		 */
	}
	
	public static void dosome(String... s) {
		System.out.println(s.length);
	}
}
