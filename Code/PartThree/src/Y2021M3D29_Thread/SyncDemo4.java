package Y2021M3D29_Thread;
/**
 * 	������
 * 	���������Ƭ�α�synchronized�����κ���Щͬ�����
 * 	ͬ����������������ͬһ��ʱ����Щ����Ƭ�ξ��ǻ���ġ���
 * 	���̲߳���ͬʱ����Щ���������С�
 * @author Grant��Vranes
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		Boo boo1 = new Boo();
		Boo boo2 = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				boo1.methodA();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				boo2.methodB();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+":�������з���A");
			Thread.sleep(5000);
			System.out.println(t.getName()+":���з���A���");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+":�������з���B");
			Thread.sleep(5000);
			System.out.println(t.getName()+":���з���B���");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}