package Y2021M3D8;
//��̬����ʾ
public class MultiTypeDemo {
	public static void main(String[] args) {
		Aooo o = new Booo();//��������
		Booo o1 = (Booo)o;//oָ��Ķ������Boo����(��ǿת)
		Inter o2 = (Inter)o;//oָ��Ķ���ʵ����Inter�ӿ�(��ǿת)
		//Cooo o3 = (Cooo)o;//ָ�����Ȳ��Ǹ�����Ҳû��ʵ�ָýӿڣ�ClassCastException����ת��
		System.out.println(o instanceof Cooo);
	}
}

interface Inter{
	
}
class Aooo{
	
}
class Booo extends  Aooo implements Inter{
	
}
class Cooo extends Aooo{
}