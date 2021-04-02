package Y2021M3D24_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	ʹ���ļ�������ļ����Ʋ���
 * @author Grant��Vranes
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	ʹ���ļ���������ȡԭ�ļ�
		 * 	ʹ���ļ�����������ļ�д����
		 * 
		 * 	���ÿ��д����˳���ԭ�ļ������ݶ�ȡ����д�뵽�����ļ���ɸ��Ʋ���
		 */
		FileInputStream src = new FileInputStream("pandoc.msi");
		FileOutputStream desc = new FileOutputStream("pandoc_cp.msi");
		long start = System.currentTimeMillis();
		
		int len = -1;
		byte[] data = new byte[200];
		while((len=src.read(data))!=-1) {
			desc.write(data,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("�������,��ʱ:"+(end-start)+"ms");//2686ms
		src.close();
		desc.close();
	}
}
