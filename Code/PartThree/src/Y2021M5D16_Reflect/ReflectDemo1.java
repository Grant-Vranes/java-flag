package Y2021M5D16_Reflect;

import java.lang.reflect.Method;

/**
 * 	java的反射机制
 * 	反射机制可以允许我们实例化一个类，调用方法操作属性从编码期
 * 	改为在运行期决定。并且也可以在运行期间动态的得知一个类的情
 * 	况（它有哪些方法，属性等反射机制可以大大提高代码的灵活度，
 * 	但是实际开发中使用要适度。过度使用反射会降低代码的运行效率。
 * @author Grant·Vranes
 *
 */
public class ReflectDemo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * 	反射的第一步：获取要操作的类的类对象
		 * 
		 * 	java中每个被JVM载的类在JVM内部都有且
		 * 	只有一个类对象（class的实例）与之对应。
		 * 	通过某个类的类对象可以得知这个类的信息
		 * 	（有哪些方法，哪些属性等等信息）
		 * 	并且可以进行实例化等操作。
		 * 
		 * 	想获取一个类的类对象的方式：
		 * 	1：类名，c1ass每个类都有一个静态属性：c1ass，可以
		 * 		直接获取这个类的类对象。
		 * 		当我们明确需要获取某个类的类对象时可以使用这种方式。
		 * 	2：通过c1ass的静态方法：forName，这种方式我们可以指定
		 * 		想加载的类的名字来获取该类的类对象
		 * 	3：通过类加载器ClassLoader
		 */
		
		//查看Person类的信息
		/*
		 * 	1:先获取Person的类对象
		 */
//		Class cls = Person.class;
		/*
		 * 	Class.forName(String className)
		 * 	这里在加载一个类时指定的字符串为加载类的完全限定名: 包名.类名
		 */
		Class cls = Class.forName("Y2021M5D16_Reflect.Person");
		String name = cls.getName();
		System.out.println(name);
		
		//getDeclaredMethods()获取自己定义的方法
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}
