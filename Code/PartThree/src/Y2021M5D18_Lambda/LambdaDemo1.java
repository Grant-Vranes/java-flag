package Y2021M5D18_Lambda;
/**
 * 	Lambda表达式
 *  Lambda可以让java以函数式编程。
 * 	该特性是自JDK8之后推出的。
 *	使用Lambda可以方便快捷创建匿名内部类
 *	语法：
 *	(参数列表)->{
 *		方法体
 *	}
 *	使用Lambda创建的匿名内部类实际所属的接口必须
 *	只能有一个方法。否则编译不通过
 * 	
 * @author Grant·Vranes
 *
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("hello");
			}
		};
		
		Runnable r2 = ()->{
			System.out.println("hello");
		};
		
		/*
		 * 	当方法中只有一句话时。方法的"{}"可以省略
		 */
		Runnable r3 = ()->System.out.println("hello");
	}
}
