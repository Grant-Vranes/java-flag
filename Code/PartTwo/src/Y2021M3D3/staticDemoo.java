package Y2021M3D3;
//演示静态方法
public class staticDemoo {

}

class Moo{
	int a;
	static int b;
	void show() {//有this
		System.out.println(this.a);
		System.out.println(Moo.b);
	}
	static void test() {//没有this
		/*
		静态方法没有this对象
		没有this意味着没有对象
		而实例变量a必须通过对象+.来访问
		结论：静态方法中不能直接访问实例成员
		*/
		//System.out.println(a);//error
		System.out.println(b);
	}
}