package Y2021M3D29_Thread;
/**
 * 	���̲߳����İ�ȫ����
 *	 ������������̲߳�������ͬһ��Դʱ�������߳��л�ʵ�ʵĲ�ȷ���ԣ��ᵼ��ִ��
 * 	������Դ�Ĵ���˳��δ�������˳��ִ�У����ֲ������ҵ����������ʱ���ܵ������̱��
 * 
 * 	�ٸ����ӣ�һ����ȥ���й�̨ȡǮ�����ֵ�ȥ����ȡǮ������ͬһ���˻�ȡǮ����������
 * 	ϵͳ���������߳�ͬʱ���У�ͬʱ����ͬһ�˻������������ܾͻ�������벻�������顣
 * 
 * 	���������������ͬһ��Դ��Ϊͬ���������������Ⱥ�˳��Ĳ���
 * 
 * @author Grant��Vranes
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table table = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Table{
	//������������20������
	private int beans = 20;
	/*
	 * 
	 * 	��һ��������synchronized���κ󣬸÷�����Ϊ��ͬ�����������������߳�
	 * 	����ͬʱ�ڷ����ڲ����С�������һ���߳�ִ�з�����ʱ�������̶߳��ڷ��������
	 * 
	 * 	ǿ���ö���߳���ִ��ͬһ����ʱ��Ϊͬ�������ͽ���˲�����ȫ����
	 * 
	 * 	�ڷ�����ʹ��synchronized����ôͬ��������������ǵ�ǰ�����������󣬼���
	 * 	�����ڲ�������this
	 */
	public synchronized int getBean() {//�ö��ӷ���
		if(beans == 0) {
			throw new RuntimeException("û�ж���");
		}
		//ģ���߳�ִ�е�����û��ʱ����
		Thread.yield();
		return beans--;
	}
}