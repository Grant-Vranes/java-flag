package Y2021M3D20_file;

import java.io.File;

/**
 * ����һ��Ŀ¼
 * @author Grant��Vranes
 *
 */
public class MKDirDemo {
	public static void main(String[] args) {
		/*
		 * ����ǰĿ¼�´���һ����Ϊdemo��Ŀ¼
		 */
		File dir = new File("./demo");
		if(!dir.exists()) {//����Ƿ���ڸ��ļ�
			dir.mkdir();
			System.out.println("Ŀ¼�������");
		}else {
			System.out.println("Ŀ¼�Ѵ���");
		}
	}
}
