package Y2021M3D24_IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 	ʹ���ļ����룻����ȡ�ļ�����
 * @author Grant��Vranes
 *
 */
public class FisDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] data = new byte[200];
		int len = fis.read(data);

		String str = new String(data,0,len,"UTF-8");//Ҳ����ʹ�ú�trim�����ո񣬵�������Ҫ����
		System.out.println(str);
		fis.close();
	}
}
