package Y2021M2D22;
//ѧ����
public class Student {
	//��Ա����
	String name;
	int age;
	String address;
	//���췽��
	public Student(String name,int age,String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	//����
	public void sayHi() {
		System.out.println("����:"+name+" ����:"+age+" ��ַ:"+address);
	}
}