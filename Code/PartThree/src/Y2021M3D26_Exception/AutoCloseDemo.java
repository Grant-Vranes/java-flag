package Y2021M3D26_Exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后推出了一个新特性:autoclose
 * 	允许编译器在编译过程中自动处理诸如流的关闭工作。
 * 	就不用像FinallyDemo2中那么繁琐
 * @author Grant·Vranes
 *
 */
public class AutoCloseDemo {
	public static void main(String[] args) {
		//这样写完后编译器会自动将代码改成FinallyDemo2的样子
		//一般在try和{之间加一个(),将流的定义放进去，凡是只有需要关闭的东西都放入其中
		try(
			/*
			 *	实现了AutoCloseable接口的类可以在这里定义。
			 *	编译器最终会将代码改变成FinallyDemo2的样子，在finally中将其关闭
			 */
			FileOutputStream fos = new FileOutputStream("fos.dat");
		){
			fos.write(1);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
