package Y2021M3D5;
//�����ڲ������ʾ
public class NstInnerDemo {
	public static void main(String[] args) {
		/*
		 * 1��������Coo��һ�������࣬����û������
		 * 2��Ϊ�������ഴ����һ��������Ϊo1
		 * 3���������е�Ϊ�����������
		 */
		Coo o1 = new Coo() {
			
		};
		
		final int num = 6;//1.8��ǰ��Ҫ����final�������ڲ�����ܷ���
		Doo o2 = new Doo() {
			void show() {
				System.out.println("���!"); 
				System.out.println(num);
			}
		};
		o2.show();
	}
}

class Eoo extends Coo{//�������������࣬��ΪEoo
}

abstract class Coo{
	
}

abstract class Doo{
	abstract void show();
}