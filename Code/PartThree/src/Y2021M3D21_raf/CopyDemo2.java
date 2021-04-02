package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	��ϣ����߶�дЧ�ʣ�����ͨ�����ÿ��ʵ�ʶ�д��������
 * 	������ʵ�ʷ����Ķ�д������������
 * 	���ֽڶ�д�������д
 * 	һ���ֽڶ�д�����д
 * 	��еӲ�̣����̣��Ŀ��дЧ�ʻ��ǱȽϺõģ����������
 * 	дЧ�ʼ���
 * @author Grant��Vranes
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		
		RandomAccessFile src = new RandomAccessFile("image.JPG", "r");
		RandomAccessFile desc = new RandomAccessFile("image_cp.JPG", "rw");
		
		/*
		 * RAF�ṩ�Ŀ��д�����ķ�����
		 * int read(byte[] date)
		 * 	һ���Զ�ȡ�������ֽ����鳤�ȵ��ֽ��������뵽�������С�����ֵΪʵ��
		 *	��ȡ�����ֽ�����������ֵΪ-1����ʾ���ζ�ȡ���ļ�ĩβ��û�ж����κ��ֽڣ�
		 * 
		 * void write(byte[] data)
		 * 	һ����д�������ֽ������е������ֽ�
		 * 
		 * void write(byte[] data, int start, int len)
		 * 	һ����д�������ֽ������д�start����ʼ��len���ֽ�
		 */
		
		//��¼ÿ��ʵ�ʶ�ȡ�����ֽ���
		int len = -1;
		//ÿ��Ҫ���ȡ���ֽ���
		/*
		 * 8λ2����	1byte	1�ֽ�
		 * 1024byte	1kb
		 * 1024kb	1mb
		 * 1024mb	1gb
		 * 1024gb	1tb
		 */
		byte[] data = new byte[1024*10];//1024byte*10=10kb
		
		long start = System.currentTimeMillis();
		while((len=src.read(data)) != -1) {
			desc.write(data,0,len);//��ΪҪ���Ƶ��ļ���һ��������10kb�ı���������Ҫע�⸴�ƽ�ȥ�Ĳ��ܶ�Ҳ������
		}
		long end = System.currentTimeMillis();
		System.out.println("�������!,��ʱ:"+(end-start)+"ms");//�������!,��ʱ:31ms
		src.close();
		desc.close();
	}
}
