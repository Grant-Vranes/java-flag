package Y2021M2D22;
//学生类
public class Student {
	//成员变量
	String name;
	int age;
	String address;
	//构造方法
	public Student(String name,int age,String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	//方法
	public void sayHi() {
		System.out.println("姓名:"+name+" 年龄:"+age+" 地址:"+address);
	}
}
