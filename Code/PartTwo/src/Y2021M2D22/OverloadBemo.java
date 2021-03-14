package Y2021M2D22;
//重载演示
/*
 * 1)同一个文件中，可以包含多个类
 * 2)public修饰的类只能有一个
 * 3)public修饰的类必须与文件名相同
 */
public class OverloadBemo {
	public static void main(String[] args) {
		Aoo a = new Aoo();//处于一个包中，是可以调用的
        a.say();
        a.say("nice");
	}
}

class Aoo{
	void say() {}
	void say(String name) {}
	void say(int age) {}
	//int say(){return 1;}//编译错误，重载与返回值没有关系
	//void say(String address){}//编译错误，重载与参数名称无关
}