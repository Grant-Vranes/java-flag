package Y2021M4D10_map;
/**
 * 	HashMap�ǲ�ѯ�ٶ��������ݽṹ���ڲ�ʹ������ʵ�֣�
 * 	��ͨ��Key��hashcodeֵ�����Ԫ���������е��±�λ�ã�
 * 	�Ӷ������˱�������Ĳ������Ӷ������˱�������Ĳ�������
 * 	����ѯ����Ԫ�ض���Ӱ�졣
 * 
 * 	����Key��hashcode��������������HashMap�ڲ������λ�ã�
 * 	��equals����������Key�Ƿ�Ϊ�ظ���ֱ��Ӱ��HashMap�Ƿ�����
 * 	�����Դ�������������Object��������ȷ����д˵����
 * 
 * 	��һ��HashMap�ڲ���������ʱ���ή�����ѯ���ܣ�Ӧ���������⡣
 * 	�����������������ڣ�������Key��hashcodeֵ��ͬ����equals
 * 	�Ƚϲ�Ϊtrueʱ�ͻ��γɡ�
 * 
 * API�ֲ�����Object����˵������������������д����
 * 	1���ɶ���д
 * 		��������Ҫ��дһ�����equals����ʱ����Ӧ����ͬ��д
 * 		hashcode����
 * 	2��һ����
 * 		�����������equals�Ƚ�Ϊtrueʱ��hashcode�������ص�����
 * 		������ȡ���֮���Ǳ���ģ�����Ӧ��������֤����������hashcode
 * 		ֵ��ͬʱequals�����Ƚ�Ϊtrue��������HashMap����ΪKeyʹ��ʱ��
 * 		��������
 * 	3���ȶ���
 * 		��һ���������equals�Ƚϵ�����ֵû�з������ı��ǰ���£���ε���
 * 		hashcode�������ص�����Ӧ����ͬ��
 * @author Grant��Vranes
 *
 */
public class key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		key other = (key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
