package Y2021M3D17_string;
/**
 * int indexOf(String str)
 * ���ظ����ַ����ڵ�ǰ�ַ����е�λ�ã�����ǰ
 * �ַ��������������ݷ���ֵΪ-1
 * @author Grant��Vranes
 *
 */
public class IndexOfDemo {
	public static void main(String[] args) {
		//			  0123456789
		String str = "thinking in java";
		int index = str.indexOf("in");
		System.out.println(index);//2
		//���ط�������������ͬ������������ͬ
		//���Դ�ָ��λ�ÿ�ʼ����
		index = str.indexOf("in",2);
		System.out.println(index);
		//�������һ�γ��ֵ�λ��
		index = str.lastIndexOf("in");
		System.out.println(index);//9
		
		
	}
}
