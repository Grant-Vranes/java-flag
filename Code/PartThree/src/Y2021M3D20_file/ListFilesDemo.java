package Y2021M3D20_file;

import java.io.File;

/**
 * 	��ȡ��ǰĿ¼�µ���������
 * @author Grant��Vranes
 *
 */
public class ListFilesDemo {
	public static void main(String[] args) {
		File dir = new File(".");
		/*
		 * boolean isFile()
		 * boolean isDirectory()
		 *	�жϵ�ǰFile�����ʾ����һ���ļ�����һ��Ŀ¼
		 */
		if(dir.isDirectory()) {
			File[] subs = dir.listFiles();
			/*
			 * File[] listFiles()
			 * 	�÷����Ὣ��ǰFile��ʾ��Ŀ¼�����������
			 */
			for(File f : subs) {
				System.out.println(f);
			}
		}
	}
}
