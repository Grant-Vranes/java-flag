package Y2021M3D26_Exception;
/**
 * 	使用当前类测试异常的抛出
 * @author Grant·Vranes
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	/*
	 * 	通常一个方法中使用throw抛出一个异常时就要在方法声明时使用
	 * 	throws声明该异常的抛出以通知调用者解决该异常。
	 * 
	 * 	只有抛出RuntimeException及其子类型异常时可以不要求这样做
	 */
	public void setAge(int age) throws IllegalAgeException {//抛出给自定义异常
		//此时，你方法声明的时候throws了异常，凡是调用这个方法都要进行异常处理，不然就会报错
		if(age<0 || age>100) {
			throw new IllegalAgeException("年龄不合法");
		}
		this.age = age;
	}
	
}
