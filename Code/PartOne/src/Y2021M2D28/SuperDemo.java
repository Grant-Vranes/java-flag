package Y2021M2D28;
//super��ʾ
public class SuperDemo {
	public static void main(String[] args) {
		Boo b = new Boo();
	}
}
class Aoo{
	Aoo(){
		System.out.println("����Ĺ��췽��");
	}
}

class Boo extends Aoo{
	Boo(){
		System.out.println("������Ĺ��췽��");
	}
}

class Coo{
	Coo(int a){}//һ��д���вι��죬ϵͳ�������ṩ�޲ι���
}

class Doo extends Coo{
	/*
	 * ���´���ΪĬ�ϣ�д��д����
	 * Doo(){
	 * 	super();//���ó�����޲ι��죬���඼û���޲ι����ˣ������Ŷ�Ȼ����
	 * }
	 */
	Doo(){
		super(5);
	}
}