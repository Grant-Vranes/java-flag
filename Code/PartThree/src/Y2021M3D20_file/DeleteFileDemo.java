package Y2021M3D20_file;

import java.io.File;

/**
 * ɾ��һ���ļ�
 * @author Grant��Vranes
 *
 */
public class DeleteFileDemo {
	public static void main(String[] args) {
		/*
		 * ����ǰĿ¼�µ�demo.txt�ļ�ɾ��
		 */
		File file = new File("./demo.txt");
		if(file.exists()) {//����Ƿ���ڸ��ļ�
			file.delete();
			System.out.println("�ļ���ɾ��");
		}else {
			System.out.println("�ļ�������");
		}
	}
}
