package Y2021M3D20_file;

import java.io.File;
import java.io.IOException;

/**
 * ʹ��File����һ���ļ�
 * @author Grant��Vranes
 *
 */
public class CreateNewFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * �ڵ�ǰĿ¼�´���һ����Ϊdemo.txt���ļ�
		 */
		File file = new File("./demo.txt");
		if(!file.exists()) {//����Ƿ���ڸ��ļ�
			file.createNewFile();
			System.out.println("�ļ��Ѵ���");
		}else {
			System.out.println("�ļ��Ѵ���");
		}
	}
}
