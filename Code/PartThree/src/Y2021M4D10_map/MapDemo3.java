package Y2021M4D10_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 	�ж�Map�Ƿ��������Ԫ�ء�
 * 	���Էֱ��ж��Ƿ����key��value
 * 	boolean containsKey(Object k)
 * 	boolean containsValue(Object v)
 * @author Grant��Vranes
 *
 */
public class MapDemo3 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("����", 99);
		map.put("��ѧ", 99);
		map.put("Ӣ��", 99);
		
		boolean ck = map.containsKey("����");
		System.out.println("����key��"+ck);//true
		
		boolean cv = map.containsValue(99);
		System.out.println("����value��"+cv);//true
		
		/*
		 * 	ע�⣺�����ַ����жϰ�����ʱ���Ǹ���equals���������жϵ�
		 * 	�����ʹ���Զ�������Ԫ�ص�ʱ��һ��Ҫ������дequals
		 */
	}
}