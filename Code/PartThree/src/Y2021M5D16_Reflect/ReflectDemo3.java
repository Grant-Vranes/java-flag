package Y2021M5D16_Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 	利用反射调用方法
 * @author Grant·Vranes
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*
		 * 	正常情况下实例化一个对象调用其方法
		 */
		Person p = new Person();
		p.sayHello();
		
		/*
		 * 	利用反射
		 */
		//1加载类对象
		Class cls = Class.forName("Y2021M5D16_Reflect");
		//2实例化
		Object o = cls.newInstance();
		/*
		 * 	3通过类对象获取其定义的方法
		 * 	Method的每一个实例用于表示一个类中的一个具体的方法
		 * 	Method(方法名,参数类型)
		 */
		Method method = cls.getMethod("sayHello", null);
		/*
		 * 	4调用该方法
		 * 		invoke(obj, args)中obj表示调用的是哪个实例的方法， args是方法的参数
		 */
		method.invoke(o, null);
		
	}
	
}
