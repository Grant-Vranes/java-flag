package Y2021M3D8;

public class test {

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