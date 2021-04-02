package Y2021M3D26_Exception;

import java.io.IOException;

/**
 * 	请分别说明:
 * 	final finally finalize
 * 
 * 	final：是关键字，可以修饰在三个地方（类、变量、方法）上
 * 		      修饰在类上，该类不可被继承
 * 		      修饰在变量上，不能被二次赋值
 * 		      修饰在方法上，不能被重写
 * 	finally：是异常捕获的最后一块，它能保证其内的代码确保执行，通常可以把
 * 			IO里的关闭流放在其中处理
 * 	finalize：每个类都有finalize方法，因为finalize是Object类中定义
 * 			  方法。简单来说，当一个类的实例被GC回收之前，会调用finalize(),
 * 			所以说finalize是一个对象生命周期中的最后一个方法，这意味着这个
 * 			方法一旦被执行完，就会被GC释放掉了。文档说finalize方法不应当做耗时操作
 * @author Grant·Vranes
 *
 */
public class FinallyDemo3 {
	public static void main(String[] args) {
		System.out.println(test("0"));//3
		System.out.println(test(null));//3
		System.out.println(test(""));//3
	}
	public static int test(String str) {
		try {
			return str.charAt(0)-'0';
		}catch(NullPointerException e) {
			return 1;
		}catch(Exception e) {
			return 2;
		}finally {
			return 3;
		}
	}
}
