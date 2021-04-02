package Y2021M3D26_Exception;
/**
 * 	测试异常的抛出
 * @author Grant·Vranes
 *
 */
public class ThrowDemo {
	public static void main(String[] args) {
		Person p = new Person();
		/*
		 * 	符合语法，但不符合业务逻辑要求，这时setAge方法中可以当作异常抛出
		 * 	要求这里调用时去处理异常
		 * 
		 * 	当调用一个含有throws声明异常抛出的方法时，要求必须处理该异常
		 * 	而处理的方式有两种：
		 * 	1、使用try-catch捕获并解决异常
		 * 	2、再当前方法上继续使用throws声明该异常的抛出
		 * 	注意：一般不要在main方法后throws异常，这是极其不负责任的表现
		 */
		try {
			p.setAge(10000);
		} catch (IllegalAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p.getAge());
	}
}
