package Y2021M3D1;
//重写的演示
public class overrideDemo {
	public static void main(String[] args) {
		
	}
}
//超类大，派生类小
class Coo{
	void show() {}
	double test() {return 0.0;}
	Doo say() {return null;}
	Coo sayHi() {return null;}
}
class Doo extends Coo{
	//int show() {return 1;}//编译错误，void时必须相等
	//int test() {return 0;}//编译错误，基本类型，必须相等
	//Coo say() {return null};//编译错误，引用类型时，小于或等于
	Doo sayHi() {return null;}
}