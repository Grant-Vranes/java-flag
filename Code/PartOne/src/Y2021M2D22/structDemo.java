package Y2021M2D22;
//���췽������ʾ
public class structDemo {
	public static void main(String[] args) {
		Stu s1 = new Stu("Grant");
		s1.show();
	}
}

class Stu{
	String name;
	int age;
	String address;
	//���췽��
	Stu(String name){
      this(name,0,null);
      //this(name,0,"����");
    }
    Stu(String name, int age){
        this(name,age,null);
    }
	Stu(String name, int age, String address) {
		this.name = name;//s1.name = "Grant"
		this.age = age;
		this.address = address;
	}
	void show() {
		System.out.println("����:"+this.name+" ����:"+this.age+" ��ַ:"+this.address);
	}
}