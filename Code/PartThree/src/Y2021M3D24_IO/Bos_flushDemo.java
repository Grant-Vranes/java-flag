package Y2021M3D24_IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 	����������Ļ���������
 * @author Grant��Vranes
 *
 */
public class Bos_flushDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		String line = "��ϲ�����������㣬�������ҵ�����";
		byte[] data = line.getBytes("UTF-8");
		/*
		 * 	��������write��������������������д���ģ������Ƚ����ݴ������ڲ��������У�
		 * 	������װ��ʱ(Ĭ��8kbװ��дһ��)�Ż���һ����ʵ��д��������ת��Ϊ��д�����Ĺ��̣�
		 */
		bos.write(data);
		/*
		 * flush������������ǿ�ƽ��������Ѿ����������һ����д����������������
		 * 	д���������м�ʱ�ԣ�����Ƶ�����ûή��дЧ�ʡ��ڸ���עд���ļ�ʱ��ʱӦ��ʹ�ô˷���
		 */
		//bos.flush();
		System.out.println("д�����");
		/*
		 * close�����л����һ��flush����
		 */
		bos.close();
	}
}