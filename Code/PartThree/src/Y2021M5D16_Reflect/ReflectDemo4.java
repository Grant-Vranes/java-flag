package Y2021M5D16_Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 	调用有参方法
 * @author Grant·Vranes
 *
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*
		 * 	Person p = new Person();
		 */
		Class cls = Class.forName("Y2021M5D16_Reflect.Person");
		Object o = cls.newInstance();
		
		/*
		 * 	p.sayHello("张三");
		 * 	
		 * 	1：获取Person的sayHello方法	void sayHello(String)
		 */
//		Method method = cls.getMethod("sayHello", Class.forName("java.lang.String"));
		Method method = cls.getMethod("sayHello", String.class);
		/*
		 * 	2:调用o这个对象的sayHello方法并传入实际参数
		 */
		method.invoke(o, "张三");
		
		
		/*
		 * 	p.sayHello("李四",22);
		 */
		Method method2 = cls.getMethod("sayHello", String.class,int.class);
		method2.invoke(o, "李四",22);
	}
}
