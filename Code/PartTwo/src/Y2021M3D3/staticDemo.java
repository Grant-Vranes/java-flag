package Y2021M3D3;
//æ≤Ã¨±‰¡ø—› æ
public class staticDemo {
	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		Loo o2 = new Loo();
		o2.show();
		Loo o3 = new Loo();
		o3.show();
	}
}

class Loo{
	int a;
	static int b;
	Loo(){
		a++;
		b++;
	}
	void show() {
		System.out.println("a="+a+",b="+b);
	}
}
