package Y2021M3D17_string;
/**
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 * �жϵ�ǰ�ַ����Ƿ����Ը����ַ�����ʼ�������
 * @author Grant��Vranes
 *
 */
public class StartsWithDemo {
	public static void main(String[] args) {
		String str = "thing";
		
		boolean starts = str.startsWith("th");
		System.out.println(starts);//true
		
		boolean ends = str.endsWith("ing");
		System.out.println(ends);//true
		
		/*	�������Ӧ�����ϴ�ͼƬ�ļ��ϣ������⵽��ĺ�׺
		 * 	����.jpg��������ͼƬ��ʽ���Ͳ������ϴ�
		 */
		
	}
}
