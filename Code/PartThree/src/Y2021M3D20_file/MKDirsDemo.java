package Y2021M3D20_file;

import java.io.File;

/**
 * ����һ���༶Ŀ¼
 * @author Grant��Vranes
 *
 */
public class MKDirsDemo {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰĿ¼�´��� a/b/c/d/e/fĿ¼
		 */
		File dir = new File("./a/b/c/d/e/f");
		if(!dir.exists()) {//����Ƿ���ڸ��ļ�
			dir.mkdir();//ǰ��������Ҫ�󴴽���Ŀ¼���ڵĸ�Ŀ¼�������,a���Ŀ¼�Ͳ����ڣ�����ľ͸���̸��
			dir.mkdirs();//�ڴ���Ŀ¼ʱ���Ὣ���в����ڵĸ�Ŀ¼ȫ������
			System.out.println("Ŀ¼�������");
		}else {
			System.out.println("Ŀ¼�Ѵ���");
		}
	}
}
