package Y2021M5D16_Reflect;

import java.util.Scanner;

/**
 * 	通过类对象快速创建实例
 * @author Grant·Vranes
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		/*
		 * 	实例化Person
		 */
		Person p = new Person();
		System.out.println(p);
		
		/*
		 * 	利用反射,可以在程序运行的时候选择需要实例化的类
		 */
		Scanner scanner = new Scanner(System.in);
		Class cls = Class.forName(scanner.nextLine());
		/*
		 * 	Class有一个快速实例化对象的方法：
		 * 	newInstance()
		 * 	但需要注意，该Class实例表示的类必须要包含无参构造方法，
		 * 	否则不能使用这种方法实例化。
		 */
		Object obj = cls.newInstance();
		System.out.println(obj);
	}
}
