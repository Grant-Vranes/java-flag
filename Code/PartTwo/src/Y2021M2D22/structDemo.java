package Y2021M2D22;
//构造方法的演示
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
	//构造方法
	Stu(String name){
      this(name,0,null);
      //this(name,0,"暂无");
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
		System.out.println("姓名:"+this.name+" 年龄:"+this.age+" 地址:"+this.address);
	}
}