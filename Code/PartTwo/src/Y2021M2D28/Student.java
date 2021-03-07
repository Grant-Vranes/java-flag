package Y2021M2D28;
//学生类
public class Student extends Person {
	//成员变量
	String stuId;
	//构造方法
	public Student(String name,int age,String address,String stuId) {
		super(name,age,address);
		this.stuId = stuId;
	}
	
}
