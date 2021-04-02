package Y2021M3D17_string;
/**
 * StringBuilderר�������޸��ַ������ݵ�API��
 * String�������Ż���Ƶ��µ�������ǲ���Ƶ���޸�(ÿ�ζ������¶���)
 * @author Grant��Vranes
 *
 */
public class StringBuilderDemo {
	public static void main(String[] args) {
		String str = "�ú�ѧϰ";
		
		//Ĭ�ϱ�ʾ���ַ���
		//StringBuilder builder = new StringBuilder();
		StringBuilder builder = new StringBuilder(str);
	
		/*
		 * append():ƴ���ַ���
		 */
		builder.append("����������");
		//StringBuilder��toString����������ȡ���ڲ���ʾ���ַ�������
		str = builder.toString();
		System.out.println(str);//�ú�ѧϰ����������
		
		/*
		 * replace():����ָ��λ������,����ҿ�
		 */
		builder.replace(5, 9, "�ı�����");
		System.out.println(builder.toString());//�ú�ѧϰ���ı�����
		
		/*
		 * delete():ɾ���ַ�����ָ��λ�õ�Ԫ��,����ҿ�
		 */
		builder.delete(0, 5);
		System.out.println(builder.toString());//�ı�����
		
		/*
		 * insert():����
		 */
		builder.insert(0, "��");
		System.out.println(builder.toString());//�Ҹı�����
	}
}
