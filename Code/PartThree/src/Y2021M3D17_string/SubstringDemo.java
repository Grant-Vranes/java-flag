package Y2021M3D17_string;
/**
 * String substring(int start, int end)
 * ��ȡָ����Χ�ڵ��ַ�������������Ϊ��ʼ���������±�
 * ע:java api��һ���ص㣬ͨ�����������ֱ�ʾ��Χʱ����
 * ����ͷ����β(����ҿ�)����
 * @author Grant��Vranes
 *
 */
public class SubstringDemo {
	public static void main(String[] args) {
		//			   0123456789
		String host = "www.baidu.com";
		System.out.println(host.substring(4, 9));//baidu
		
		//�Ӳ�����ʼ��ȡ��ĩβ
		System.out.println(host.substring(4));
		
	}
}
