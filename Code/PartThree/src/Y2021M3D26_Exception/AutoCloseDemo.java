package Y2021M3D26_Exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7֮���Ƴ���һ��������:autoclose
 * 	�����������ڱ���������Զ������������Ĺرչ�����
 * 	�Ͳ�����FinallyDemo2����ô����
 * @author Grant��Vranes
 *
 */
public class AutoCloseDemo {
	public static void main(String[] args) {
		//����д�����������Զ�������ĳ�FinallyDemo2������
		//һ����try��{֮���һ��(),�����Ķ���Ž�ȥ������ֻ����Ҫ�رյĶ�������������
		try(
			/*
			 *	ʵ����AutoCloseable�ӿڵ�����������ﶨ�塣
			 *	���������ջὫ����ı��FinallyDemo2�����ӣ���finally�н���ر�
			 */
			FileOutputStream fos = new FileOutputStream("fos.dat");
		){
			fos.write(1);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}