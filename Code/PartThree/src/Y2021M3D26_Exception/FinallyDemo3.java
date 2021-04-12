package Y2021M3D26_Exception;

import java.io.IOException;

/**
 * 	��ֱ�˵��:
 * 	final finally finalize
 * 
 * 	final���ǹؼ��֣����������������ط����ࡢ��������������
 * 		      ���������ϣ����಻�ɱ��̳�
 * 		      �����ڱ����ϣ����ܱ����θ�ֵ
 * 		      �����ڷ����ϣ����ܱ���д
 * 	finally�����쳣��������һ�飬���ܱ�֤���ڵĴ���ȷ��ִ�У�ͨ�����԰�
 * 			IO��Ĺر����������д���
 * 	finalize��ÿ���඼��finalize��������Ϊfinalize��Object���ж���
 * 			  ����������˵����һ�����ʵ����GC����֮ǰ�������finalize(),
 * 			����˵finalize��һ���������������е����һ������������ζ�����
 * 			����һ����ִ���꣬�ͻᱻGC�ͷŵ��ˡ��ĵ�˵finalize������Ӧ������ʱ����
 * @author Grant��Vranes
 *
 */
public class FinallyDemo3 {
	public static void main(String[] args) {
		System.out.println(test("0"));//3
		System.out.println(test(null));//3
		System.out.println(test(""));//3
	}
	public static int test(String str) {
		try {
			return str.charAt(0)-'0';
		}catch(NullPointerException e) {
			return 1;
		}catch(Exception e) {
			return 2;
		}finally {
			return 3;
		}
	}
}
/*
 * 	 Ϊʲô��������
 * 	 ʵ���ϣ����ǵ���һ������ʱ���ڴ�ʵ����������һ������������˵��һ��������
 * 	���������ʲô�����أ�ȡ������ķ�����ʲô����/����ֵ��ʲô���͡�����������ķ���ֵ��
 * 	������try��return����һ��ֵ����ʱ���丳ֵ���ڴ�����������Ĳ�����
 * 	 Ȼ���Ҫ�����쳣������ƣ�������ִ��finally�е����飬finally����returnһ��ֵ��
 * 	�ͽ��ڴ��������Ĳ�����ֵ�������ˣ����Է��صľ���3
 */
 

  
