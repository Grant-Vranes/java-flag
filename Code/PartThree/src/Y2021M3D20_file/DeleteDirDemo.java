package Y2021M3D20_file;

import java.io.File;

/**
 * ɾ��Ŀ¼
 * @author Grant��Vranes
 *
 */
public class DeleteDirDemo {
	public static void main(String[] args) {
		/*
		 * ɾ����ǰĿ¼����Ϊdemo��Ŀ¼
		 */
		File dir = new File("./demo");
		if(dir.exists()) {//����Ƿ���ڸ�Ŀ¼
			dir.delete();//ǰ��Ҫ�󣺸�Ŀ¼�����Ǹ���Ŀ¼
			System.out.println("ɾ�����");
		}else {
			System.out.println("Ŀ¼������");
		}
	}
}
