package Y2021M2D20;

public class Demo_1 {
	public static void main(String[] args) {
		/*
		 * 1.�����������+��-��*��/��%��++��--
		 * 		1��%��ȡģ/ȡ�����㣬����Ϊ0��Ϊ����
		 * 		2��++/--������1/�Լ�1�����ڱ���ǰҲ���ں�
		 * 			a������ʹ��ʱ����ǰ�ں� ��һ��
		 * 			b����ʹ��ʱ����ǰ�ں�һ��
		 * 				a++��ֵΪa
		 * 				++a��ֵΪa+1			
		 * 	
		 */
		//++/--����ʹ��
		int a = 5, b = 5;
		a++;//�൱��a = a + 1;
		++b;//�൱��b = b + 1;
		System.out.println(a);//6
		System.out.println(b);//6
		
		System.out.println("--------------");
		//++/--��ʹ��
		int c = 5, d = 5;
		//1����c++��ֵ5��ֵ��e
		//2��c����1���6
		//---���ú��---
		int e = c++;
		//1��++d������1���6
		//2����++d��ֵ6��ֵ��f
		//---�ȼӺ���---
		int f = ++d;
		System.out.println(c);//6
		System.out.println(d);//6
		System.out.println(e);//5
		System.out.println(f);//6
		System.out.println("------------");
		int g = 5, h = 5;
		System.out.println(g++);//5
		System.out.println(g);//6
		System.out.println(++h);//6
		System.out.println(h);//6
	}
}
