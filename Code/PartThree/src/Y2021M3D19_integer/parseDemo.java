package Y2021M3D19_integer;
/**
 *	 ��װ�඼�ṩ��һ����̬����
 * 	parseXXX(String str)
 * 	���Խ��ַ�������Ϊ��Ӧ�Ļ������ͣ�������Ҫע�⣬���ַ���
 * 	�����ܹ���ȷ�����û������Ϳ��Ա����ֵ��������׳��쳣
 * 	���磺java.lang.NumberFormatException��ʾ
 * 		�ַ�����ת���ֵ�ʱ���ʽ����
 * @author Grant��Vranes
 *
 */
public class parseDemo {
	public static void main(String[] args) {
		String str = "123";//123.123����'a'���ᱨ����Ϊ��Ҫת�������Ͳ�����
		int d = Integer.parseInt(str);
		System.out.println(d);
		
		double dou = Double.parseDouble("123.123");
		System.out.println(dou);
	}
	
}
