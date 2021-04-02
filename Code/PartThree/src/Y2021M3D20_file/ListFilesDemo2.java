package Y2021M3D20_file;

import java.io.File;
import java.io.FileFilter;

/**
 * ListFiles�ṩ��һ�����صķ���������ָ��һ���ļ�������(FileFilter),
 *	 Ȼ������ù�����Ҫ��������
 * @author Grant��Vranes
 *
 */
public class ListFilesDemo2 {
	public static void main(String[] args) {
		/*
		 *	 ��ȡ��ǰĿ¼��������"."��ͷ������
		 */
		File dir = new File(".");//��ǰĿ¼
		FileFilter filter = new FileFilter() {//�����ڲ���
			//��д����������accept����
			public boolean accept(File file) {
				String name = file.getName();
				return name.startsWith(".");
			}
		};
//		MyFilter myFilter = new MyFilter();
//		myFilter.accept(dir);
//		File[] subs = dir.listFiles(myFilter);
		File[] subs = dir.listFiles(filter);
		for(File f : subs) {
			System.out.println(f);
		}
	}
}

//class MyFilter implements FileFilter{
//	@Override
//	public boolean accept(File file) {
//		String name = file.getName();
//		return name.startsWith(".");
//	}
//	
//}