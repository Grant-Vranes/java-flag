package Y2021M3D20_file;

import java.io.File;

/**
 * 	��ɷ�����ʵ��ɾ������File����ʾ���ļ���Ŀ¼
 * @author Grant��Vranes
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir = new File("./a");//aĿ¼�¿����ж༶Ŀ¼��
		delete(dir);
	}
	public static void delete(File f) {
		if(f.exists()) {
			if(f.isDirectory()) {//��Ŀ¼
				//����ո�Ŀ¼
				File[] subs = f.listFiles();
				for(File file : subs) {
					delete(file);//�ݹ�˼��
				}
			}
			f.delete();//�������Ŀ¼���ļ���ֱ��ɾ��
		}else {
			System.out.println("�ļ�������");
		}
	}
}
