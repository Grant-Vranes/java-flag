package Y2021M3D24_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	������
 * 	��������һ�Ը߼���������ʱ��߶�дЧ�ʡ�
 * 	���������Ժ��������ǽ��������д���ǿ�
 * 	��д��������������ʱ���ᱻת��Ϊ���д����
 * 
 * 	java.io.BufferedInputStream
 * 	java.io.BufferedOutputStream
 * @author Grant��Vranes
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("pandoc.msi");
		BufferedInputStream bis = new BufferedInputStream(fis);//������
		
		FileOutputStream fos = new FileOutputStream("pandoc_cp.msi");
		BufferedOutputStream bos = new BufferedOutputStream(fos);//������
		
		long start = System.currentTimeMillis();
		
		int len = -1;
		byte[] data = new byte[200];
		while((len=bis.read(data))!=-1) {
			bos.write(data,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("�������,��ʱ:"+(end-start)+"ms");//194ms
		bis.close();
		bos.close();
	}
}
