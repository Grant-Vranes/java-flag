package Y2021M3D8;
//接口的演示
public class InterfaceDemo {
	public static void main(String[] args) {
		
	}
}

//演示接口实现
interface Inter1{
    void show();
}
interface Inter2{
	void test();
}
abstract class Aoo{
    abstract void say();
}
class Boo extends Aoo implements Inter1,Inter2{
    public void show(){}
    public void test(){}
    void say() {}
}

//演示接口语法
interface Inter01{
	public static final int NUM = 5;
    public abstract void show();
    int COUNT = 5;//默认public static final
    void test();//默认public abstract
    
    //int number;//编译错误，常量必须声明同时初始化，这就不属于常量的定义，所以会报错
	//void say(){};//编译错误，抽象方法不能有方法体，这就不属于抽象方法的定义，所以报错
}