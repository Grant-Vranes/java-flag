package Y2021M3D24_IO;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 	使用当前类实例测试对象流的对象读写操作
 * 
 * 	当一个类的实例希望可以被对象流进行读写，那么
 * 	该类必须实现：java.io.Serializable接口
 * 	与此同时，当前类中所有引用类型的属性，他们对应的类也必须实现该接口
 * 	
 * 	实现该接口表示该类可以被序列化
 * 
 * 	一般实现接口一定要重写其方法，但是实现这个接口中不需要，
 * 	因为它是一个签名接口，里面没有任何方法
 * @author Grant·Vranes
 *
 */
public class Person implements Serializable{
	/**
	 * 	当一个类实现了Serializable接口后，要求应当定义一个常量
	 * 	serialVersionUID，即：序列化版本号
	 * 
	 * 	序列化版本号影响反序列化是否成功。当对象输入流在进行对象反序
	 * 	列化时会检查该对象与当前类的版本是否一致，不一致则反序列化时
	 * 	会抛出异常导致反序列化失败。
	 * 	一致则可以进行反序列化，原则是对应的属性进行还原。
	 * 
	 * 	如果我们不定义该版本号，编译器会在编译当前类时根据结构生成一
	 * 	个版本号，那么版本号一定会改变。这样以前的对象一定是不可以反序列化了
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * transient关键字修饰的属性在对象序列化时会被忽略。
	 *	 忽略不必要的属性可以达到对象瘦身的作用
	 */
	private transient String[] otherInfo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String[] otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	//重写toString方法
	public String toString() {
		return name+","+age+","+gender+","+Arrays.toString(otherInfo);
	}
	
}
