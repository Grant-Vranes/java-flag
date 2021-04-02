package Y2021M3D19_Object;
/**
 *	 ����Point��дObject��ط���
 * @author Grant��Vranes
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point p = new Point(12,13);
		
		/*
		 * 	ͨ�����Ƕ�����������Ҫʹ�õ�toString����ʱ��
		 * 	��Ӧ����д���������Object�ṩ��������Ǹö���
		 * 	�ľ��(�൱�ڸö��������+��ַ)��ûʲôʵ�����塣
		 */
		String str = p.toString();
		System.out.println(str);//(12,13)
	
		/*
		 *  System.out.println(Object obj);
		 * 	�÷����Ὣ���������toString�������ص��ַ���
		 * 	���������̨
		 */
		System.out.println(p);//(12,13)������û�е���toString��������ʵ����java��APIĬ�ϵ�����
	
		Point p2 = new Point(12, 13);
		System.out.println(p==p2);//false
		System.out.println(p.equals(p2));//û��дequals��������false��д��֮���true
		/*
		 * Object�е�equals����Ĭ����ִ��==������
		 * public boolean equals(Object obj) {
         *		return (this == obj);
    	 * }
    	 * 	�Լ���������У���Ҫȥ��д������Ȼû���κ�����(��==һ����Ч��)������java�Ѿ�����õ������ǿ���ֱ���õ�(��Ϊ���Ѿ���д����)
		 *	���Ƕ���������ʹ��equals,��Ӧ����д���������Object
		 *	�ṩ��equals���������ڲ������á�==�����бȽϵģ�û��ʵ������
		 *	Java API�ṩ���࣬toString��equals���������ƽ�������д��
		 */
		
	}
}
