package Y2021M3D5;
//匿名内部类的演示
public class NstInnerDemo {
	public static void main(String[] args) {
		/*
		 * 1）创建了Coo的一个派生类，但是没有名字
		 * 2）为该派生类创建了一个对象，名为o1
		 * 3）大括号中的为派生类的类体
		 */
		Coo o1 = new Coo() {
			
		};
		
		final int num = 6;//1.8以前需要加上final，匿名内部类才能访问
		Doo o2 = new Doo() {
			void show() {
				System.out.println("你好!"); 
				System.out.println(num);
			}
		};
		o2.show();
	}
}

class Eoo extends Coo{//正常创建派生类，名为Eoo
}

abstract class Coo{
	
}

abstract class Doo{
	abstract void show();
}