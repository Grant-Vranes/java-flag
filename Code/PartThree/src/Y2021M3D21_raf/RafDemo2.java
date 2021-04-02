package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF��д�����������ݣ��Լ�RAF��ָ�����
 * @author Grant��Vranes
 *
 */
public class RafDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		
		//��ȡָ��
		long pos = raf.getFilePointer();
		System.out.println("pos:" + pos);//0
		
		//д��һ��int�����ֵ���ļ���
		int max = Integer.MAX_VALUE;
		/*
		 * int ���ֵ��2������ʽ
		 * 							  vvvvvvvv
		 * 01111111 11111111 11111111 11111111
		 * max>>>24����24λ					   V���
		 * 00000000 00000000 00000000 01111111 11111111 11111111 11111111
		 * max>>>16							   V���	
		 * 00000000 00000000 01111111 11111111 11111111 11111111
		 * max>>>8							   V���
		 * 00000000 01111111 11111111 11111111 11111111
		 * max>>>0
		 * 01111111 11111111 11111111 11111111
		 */
		
		/*
		 * raf.write(max);//д�����
		 * void write(int d)
		 * 	���ļ���д��1�ֽڣ�д���Ǹ�����intֵ��Ӧ��2���Ƶġ��Ͱ�λ��
		 * 	���Դ˴�д��Ĳ�������ȷ��int���ֵ��ֻ��int�ĵͰ�λ
		 * 	֪����write��������ԣ����ǾͿ���ʹ��λ���㣬һ��һ�ε�д��
		 */
		raf.write(max>>>24);
		System.out.println("pos:" + raf.getFilePointer());
		raf.write(max>>>16);
		System.out.println("pos:" + raf.getFilePointer());
		raf.write(max>>>8);
		System.out.println("pos:" + raf.getFilePointer());
		raf.write(max);
		System.out.println("pos:" + raf.getFilePointer());
		
		/*
		 * void writeInt(int d)
		 * 	����д��4���ֽ�(32λ)����������intֵ���
		 * 	��ͬ������4��write�������������ϻ�������������
		 */
		raf.writeInt(max);
		System.out.println("pos:" + raf.getFilePointer());
		raf.writeLong(123L);
		System.out.println("pos:" + raf.getFilePointer());
		raf.writeDouble(123.123);
		System.out.println("pos:" + raf.getFilePointer());;
		
		System.out.println("д����ϣ�");
		
		/*
		 *	 ��һ���ֽڣ������䷵��ֵΪ-1��˵���������ļ�ĩβ��
		 *	������Ϊraf����ָ��ĸ������д������ĵ�ʱ��
		 *	ָ���Ѿ������ļ�ĩβ�������ٴζ���ʱ�򣬴�ָ�뿪ʼ��
		 *	RandomAccessFile�����ڵ�ǰָ���λ�ý��ж���д
		 */
		int d = raf.read();
		System.out.println(d);//-1
		
		d = raf.readInt();//���ĸ��ֽ�
		System.out.println(d);//����
		/*	java.io.EOFException,(end of file),
		 * 	ʹ�ó�read()���readXXX()��������ĩβ������������
		 */
		
		//�ƶ�ָ��λ��
		raf.seek(0);//�ƶ����ļ���ʼ��λ��
		d = raf.readInt();//���ĸ��ֽ�
		System.out.println(d);
		
		raf.seek(0);
		long l = raf.readLong();//���˸��ֽ�
		System.out.println(l);//����������Ľ��������ǰ����writeInt��ֵ��ĳ����������˵Ҳ��һ�����룬��ʲôд�ľ���ʲô��
		
		raf.close();
	}
}
