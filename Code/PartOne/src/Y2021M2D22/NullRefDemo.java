package Y2021M2D22;

//null���������ͻ��Ⱥ���ʾ
public class NullRefDemo {
	public static void main(String[] args) {
		Student zs = new Student("zs",19,"Arka");
		System.out.println(zs.age);
		zs = null;//�գ�û��ָ���κζ���
		//System.out.println(zs.age);//NullPointerException
	
		Student ls = new Student("ls",19,"kroka");
		Student lss = ls;//ָ��ͬһ������
		lss.age = 45;
		System.out.println(ls.age);//45
		
		int a = 5;
		int b = 6;
		a = b;
		System.out.println(a);
		
	}
}