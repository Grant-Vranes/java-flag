package Y2021M4D4_Collection;
/**
 *	������
 * @author Grant��Vranes
 *
 */
public class TypeDemo2 {
	public static void main(String[] args) {
		Location<Integer> loc1 = new Location<Integer>(1,2);
		
		/*
		 * 	���Ϳ��Բ�ָ������ָ������Ĭ�ϵ�Object���Ϳ���
		 */
		Location loc2 = loc1;//loc2�е�Ԫ�ؾ���Object���͵���
		loc2.setX("��");//��ζ��ԭ����Integerʵ��û�ˣ��ĳ���String����ʵ��
		System.out.println("loc2:"+loc2);//loc2:(x=��, y=2)
		
		//�ٴ���loc1�ǶȻ�ȡx
		int x1 = loc1.getX();//�������쳣,�ַ�������ת����Integer
		System.out.println("x1:"+x1);//error
	}
}
