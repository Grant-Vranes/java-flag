package Y2021M3D29_Thread;
/**
 * 	�ڶ��ִ����̵߳ķ�ʽ
 * 	ʵ��Runnable�ӿڣ����������߳�����
 * @author Grant��Vranes
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		//ʵ������������
		Runnable r1 = new MyRunnable1();
		Runnable r2 = new MyRunnable2();
		//���������̲߳�ָ������
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class MyRunnable1 implements Runnable{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("�߳�1");
		}
	}
}

class MyRunnable2 implements Runnable{
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("�߳�2");
		}
	}
}
