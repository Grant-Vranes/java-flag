package Y2021M3D20_file;

import java.io.File;

/**
 * java.io.File;
 * File��ÿһ��ʵ�����ڱ�ʾӲ���ϵ�һ���ļ�����Ŀ¼
 * ʹ��File����:
 * 1.�������ʾ���ļ���Ŀ¼��������Ϣ(����,��С,����Ȩ�޵���Ϣ)
 * 2.�����ļ���Ŀ¼(����,ɾ��)
 * 3.����Ŀ¼����
 * ���ǲ��ܷ����ļ�����
 * @author Grant��Vranes
 *
 */
public class FileDemo {
	/*
	 * ����Fileʱ��ָ����·��ͨ��ʹ�����·�����ô����ڣ����Կ�ƽ̨
	 * ���·��������������Ҫ����������л���ָ����λ��
	 * ��ecplise������java����ʱ��ָ�����ж�·���С���ǰĿ¼���ǵ�ǰ�������ڵ���ĿĿ¼
	 */
	public static void main(String[] args) {
		File file = new File("./test.txt");
		
		/*
		 * ��ȡ�ļ���
		 */
		String name = file.getName();
		System.out.println(name);
		
		/*
		 * ��ȡ�ļ���С(�ֽ���)
		 */
		long length = file.length();
		System.out.println(length);
		
		/*
		 * ��ȡȨ�����
		 */
		boolean cr = file.canRead();//�Ƿ�ɶ�
		boolean cw = file.canWrite();//�Ƿ��д
		System.out.println("�ɶ�:"+cr);
		System.out.println("��д:"+cw);
		
		/*
		 * �Ƿ�����
		 */
		boolean ih = file.isHidden();
		System.out.println(ih);
	}
}