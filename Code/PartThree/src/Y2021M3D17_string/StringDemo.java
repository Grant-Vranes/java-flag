package Y2021M3D17_string;
/**
 *	String是不变对象，JVM对其做了一个优化，在内存中开辟了一段区域
 *	 作为常量池，凡是通过“字面量”形式创建的字符串对象都会缓存并重用。
 *	 因为重用对象，所以该对象内容不可变
 * @author Grant·Vranes
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		String s1 = "123abc";//字面量形式创建，不是new出来的
		String s2 = "123abc";//s1重用s1创建的字符串对象
		System.out.println(s1==s2);//true
		
		//修改内容会创建并引用新对象
		s1 = s1+"!";
		System.out.println("s1:"+s1);//123abc!
		System.out.println("s2:"+s1);//123abc	不会受影响
	
		//new一定创建新对象
		String s4 = new String("123abc");
		System.out.println(s2==s4);//false

		/*
		 *	编译器有一个优化措施，当编译源代码时发现一个计算表达式
		 *	所有参数都是字面量时(非变量),会直接进行计算，并将结果编
		 *	译到class文件中。所以，下面代码在class文件中为
		 *	String s5 = "123abc";
		 */
		String s5 = "123" + "abc";
		System.out.println(s2==s5);//true
		
		/*
		 *计算表达式一方为变量，那么会在运行期间凭借，那么会创建新对象
		 */
		String s = "123";
		String s6 = s + "abc";
		System.out.println(s2==s6);//false
	}
}
