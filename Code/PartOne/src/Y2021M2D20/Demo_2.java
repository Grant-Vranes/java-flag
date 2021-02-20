package Y2021M2D20;

public class Demo_2 {
	public static void main(String[] args) {
		/* 测试：
		 * 1）输出5%3，输出6%3，输出3%6
		 * 2）声明整型变量a并赋值为5，a++，输出a
		 * 	   	声明整型变量a并赋值为5，++b，输出b
		 * 3）声明整型变量c和d，并分别赋值为5.
		 * 		声明整型变量e并赋值为c++，输出c，输出e
		 * 		声明整型变量f并赋值为++d，输出d，输出f
		 * 4）声明整型变量g和h，并分别赋值为5
		 * 		输出g--，输出g
		 * 		输出--h，输出h
		 */
		//1）
		System.out.println(5%3);//2
		System.out.println(6%3);//0
		System.out.println(3%6);//3
		
		//2)
		int a = 5, b = 5;
		System.out.println(a++);//5
		System.out.println(a);//6
		System.out.println(++b);//6
		System.out.println(b);//6
		
		//3)
		int c = 5, d = 5;
		int e = c++;
		System.out.println(c);//6
		System.out.println(e);//5
		int f = ++d;
		System.out.println(d);//6
		System.out.println(f);//6
		
		//4)
		int g = 5, h = 5;
		System.out.println(g--);//5
		System.out.println(g);//4
		System.out.println(--h);//4
		System.out.println(h);//4
	}
}
