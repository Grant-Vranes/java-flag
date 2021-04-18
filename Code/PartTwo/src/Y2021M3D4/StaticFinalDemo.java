package Y2021M3D4;
//static final 演示
public class StaticFinalDemo {
	public static void main(String[] args) {
		System.out.println(Aoo.PI);//类名点来访问
		System.out.println(Boo.num);
		/*
		 * 1)加载Boo.class到到方法区中
		 * 2)静态变量num也存储到方法区中
		 * 3)到方法区中获取num并输出
		 */
		System.out.println(Boo.COUNT);
		/*
		 * 编译器在编译时将常量直接替换为具体的值，效率高
		 * 相当于System.out.println(5);
		 */
	}

}

class Aoo{
	public static final double PI = 3.14159;
	//public static final int NUM;//编译错误
}
class Boo{
	public static int num = 5;//静态变量，属于类的，存储在方法区中，只有一份
	public static final int COUNT = 5;//常量
}