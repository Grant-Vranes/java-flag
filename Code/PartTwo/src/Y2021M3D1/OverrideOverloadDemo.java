package Y2021M3D1;
//重写与重载的演示
//注意：重载看参数/引用类型;重写看对象类型
public class OverrideOverloadDemo {
	public static void main(String[] args) {
		Goo goo = new Goo();
		Eoo o = new Foo();//向上造型
		goo.test(o);//重载看参数/引用类型，重写看对象类型
	}
}

//test()方法是在重载，show()方法是在重写
class Eoo{
	void show() {
		System.out.println("超类show");
	}
}
class Foo extends Eoo{
	void show() {
		System.out.println("派生类show");
	}
}
class Goo{
	void test(Eoo o) {
		System.out.println("超类型参数");
		o.show();//重写看对象类型；如果没有重写的话，向上造型称王
	}
	void test(Foo o) {
		System.out.println("派生类型参数");
		o.show();
	}
}