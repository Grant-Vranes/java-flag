package Y2021M2D20;

public class Demo_2 {
	public static void main(String[] args) {
		/* ���ԣ�
		 * 1�����5%3�����6%3�����3%6
		 * 2���������ͱ���a����ֵΪ5��a++�����a
		 * 	   	�������ͱ���a����ֵΪ5��++b�����b
		 * 3���������ͱ���c��d�����ֱ�ֵΪ5.
		 * 		�������ͱ���e����ֵΪc++�����c�����e
		 * 		�������ͱ���f����ֵΪ++d�����d�����f
		 * 4���������ͱ���g��h�����ֱ�ֵΪ5
		 * 		���g--�����g
		 * 		���--h�����h
		 */
		//1��
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
