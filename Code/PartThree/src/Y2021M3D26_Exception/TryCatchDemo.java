package Y2021M3D26_Exception;
/**
 * 	java�쳣��������е�try-catch
 * 	try���������������ܳ���Ĵ���Ƭ�Σ�catch
 * 	����������Щ������Ըô�����д���
 * @author Grant��Vranes
 *
 */
public class TryCatchDemo {
	public static void main(String[] args) {
		System.out.println("program start");
		
		/*
		 * 	��JVMִ�д���ʱ���� һ������ʱ������ݴ���ʵ������Ӧ���쳣ʵ����
		 * 	��������ִ�й������ý�ȥ��Ȼ�󽫸��쳣�ڳ�������λ���׳���
		 * 	֮��try-catch������û������Ϊ�����������ڵķ���û��
		 * 	����쳣����������֮���쳣�׳����÷���֮�⡣
		 */
		try {
			String str = null;
			System.out.println(str.length());
			//try�����г�������������ݲ�ִ��
			System.out.println("��ִ��");
		}catch(NullPointerException e) {//�������ǿ��ܳ��ֵĴ���ʵ��
			System.out.println("�����˿�ָ��");
		}catch(StringIndexOutOfBoundsException e) {
			//ͨ�������try���׳���һ�����ܲ�ֹһ��������catch����д����������쳣һ��Ҫ�Ȳ���
			System.out.println("�ַ����±�Խ����");
		}catch(Exception e) {
			/*	��ʵ������ʱ���������벻���Ĵ�������Ӧ�������һ��catch������
			 * 	Exception����������һ��δ�����쳣���³����ж�
			 * 	
			 */
			System.out.println("�������");
		}
		
		
		System.out.println("program end");
	}
}
