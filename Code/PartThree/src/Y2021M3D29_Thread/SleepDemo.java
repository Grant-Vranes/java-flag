package Y2021M3D29_Thread;
/**
 * 	�߳��ṩ��һ����̬������
 * 	static void sleep(long ms)
 * 	ʹ��������������߳�����ָ�����롣��ʱ����̻߳��Զ��ص�RUNNABLE
 * 	״̬���ȴ��ٴβ������С�
 * @author Grant��Vranes
 *
 */
public class SleepDemo {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		
		try {
			Thread.sleep(5000);//ͣ��5000ms=5s
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("���������");
	}
}