package Y2021M3D29_Thread;
/**
 * 	�ػ��߳�
 * 	�ػ��߳��ֳ�Ϊ��̨�̣߳�Ĭ�ϴ������̶߳�����ͨ�̻߳��Ϊ
 * 	ǰ̨�̣߳��߳��ṩ��һ��������
 * 	void setDaemon(noolean on)
 * 	ֻ�е��ø÷������������trueʱ�����̲߳Żᱻ����Ϊ�ػ��߳�
 * 
 * 	�ػ��߳���ʹ��������ͨ�߳�û�в�𣬵����ڽ���ʱ������һ������
 * 	�����߳̽���ʱ�����������е��ػ��̶߳��ᱻǿ��ֹͣ��
 * 	
 * 	���̵߳Ľ�����ָ����һ�����������е���ͨ�̶߳�����ʱ�����̼�������
 * 
 * 	�����ػ��̵߳Ĺ������һ���ǣ����߳�һֱ���ڣ������Զ��رգ�ȫ�̶���Ҫʹ�ã������̽�����Ͳ���Ҫ��
 * @author Grant��Vranes
 *
 *	��������������rose�߳�ִ�����jack�߳�Ҳִ�����
 */
public class DaemonThreadDemo {
	public static void main(String[] args) {
		//ģ��ܿ˺�rose�������������ܿ��ػ�rose
		Thread rose = new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);//1���Ӻ�һ��
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:aaaaaaaaaaaa");
				System.out.println("��ˮ��");
			}
		};
		
		Thread jack = new Thread() {
			public void run() {
				while(true) {
					System.out.println("jack:you jump , i jump");
					try {
						Thread.sleep(1000);//1���Ӻ�һ��
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		rose.start();
		
		/*
		 * ����jackΪ�ػ��߳�
		 * ע�⣬�������߳�����ǰ��������
		 * ��ͨ�̶߳�������ʱ�������е��ػ��̶߳��ᱻǿ��ֹͣ��rose����һ����ͨ�߳�
		 */
		jack.setDaemon(true);
		jack.start();
		
		/*
		 * ע�⣺mian��������Ҳ��һ����ͨ�̣߳�ǰ̨�̣߳���ִ����main���������д���
		 * �ͻ��Զ������������main����һ����ѭ����main��һֱ�������ˣ��ػ��߳̾�һֱ����
		 */
	}
}