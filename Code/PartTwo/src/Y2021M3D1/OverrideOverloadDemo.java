package Y2021M3D1;
//��д�����ص���ʾ
public class OverrideOverloadDemo {
	public static void main(String[] args) {
		Goo goo = new Goo();
		Eoo o = new Foo();
		goo.test(o);//���ؿ�����/��������
	}
}
class Eoo{
	void show() {
		System.out.println("����show");
	}
}
class Foo extends Eoo{
	void show() {
		System.out.println("������show");
	}
}
class Goo{
	void test(Eoo o) {
		System.out.println("�����Ͳ���");
		o.show();//��д����������
	}
	void test(Foo o) {
		System.out.println("�������Ͳ���");
		o.show();
	}
}