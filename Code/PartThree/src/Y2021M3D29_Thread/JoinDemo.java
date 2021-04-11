package Y2021M3D29_Thread;
/**
 * �߳��ṩ��һ��������
 * void join()
 * �÷�������Э���߳�֮���ͬ������
 * 
 * ͬ�����첽��
 * ͬ�����У�������˳��
 * �첽���У����д�����˳�򣬶��̲߳������о����첽����
 * @author Grant��Vranes
 *	
 *	�������������ǣ�������download�߳�ִ����Ϻ���ִ��
 *	show�̣߳�ͼƬ������Ϻ��ٽ���ͼƬչʾ��
 */
public class JoinDemo {
	//��ʶͼƬ�Ƿ��������
	private static boolean isFinish = false;
	/*
	 * ���isFinish����ֻ��main������ʹ�ã�Ϊʲô������main�������أ�
	 * ��ΪisFinish�������main�����У���һ�������ľֲ������������������
	 * ���ֲ��ڲ���������ʱ��������������Ǹ�������final�ģ�Ȼ��������final
	 * ���֣�final��ֵ�ǲ����޸ĵģ������㣡�����ֱ�ӽ�������Ϊһ����Ա���ԡ�
	 */
	
	public static void main(String[] args) {
		Thread download = new Thread() {
			public void run() {
				System.out.println("down:��ʼ����ͼƬ...");
				for (int i = 0; i <= 100; i++) {
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(20);
					}catch(InterruptedException e) {
					}
				}
				System.out.println("down:ͼƬ�������");
				isFinish = true;
			}
		};
		
		Thread show = new Thread() {
			public void run() {
				System.out.println("show:��ʼ��ʾͼƬ");
				//����ͼƬǰӦ���ȵȴ������߳̽�ͼƬ����
				//��show����download�ѻ��ȸ��꣬��������Ҫ����show
				
				try {
					/*
					 * show�߳��ڵ���download.join()�����󣬱����Լ�������download���棬
					 * �ͽ���������״̬��ֱ��download�̵߳�run����ִ����ϲŻ�������
					 */
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!isFinish) {
					//�Զ����쳣
					throw new RuntimeException("����ͼƬʧ��");
				}
				System.out.println("show:��ʾͼƬ���");
			}
		};
		
		download.start();
		show.start();
	}
}