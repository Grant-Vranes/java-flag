package Y2021M5D16_Reflect;
/**
 * 	测试反射功能的类
 * @author Grant·Vranes
 *
 */
public class Person {
	public void sayHello() {
		System.out.println("Hello!");
	}
	
	public void sayHello(String name) {
		System.out.println("Hello! " + name);
	}
	
	public void sayHello(String name, int age) {
		System.out.println("Hello! " + name + ",age:" + age);
	}
	
	public void satHi() {
		System.out.println("Hi!");
	}
}
