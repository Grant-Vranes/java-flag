package Y2021M2D28;
//super演示
public class SuperDemo {
	public static void main(String[] args) {
		Boo b = new Boo();
	}
}
class Aoo{
	Aoo(){
		System.out.println("超类的构造方法");
	}
}

class Boo extends Aoo{
	Boo(){
		System.out.println("派生类的构造方法");
	}
}

class Coo{
	Coo(int a){}//一旦写了有参构造，系统不会再提供无参构造
}

class Doo extends Coo{
	/*
	 * 如下代码为默认，写不写都在
	 * Doo(){
	 * 	super();//调用超类的无参构造，超类都没有无参构造了，调不着定然报错
	 * }
	 */
	Doo(){
		super(5);
	}
}
