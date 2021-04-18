package Y2021M4D10_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 	Map�ı���
 * 	����Map�����ַ�ʽ
 * 	1���������е�key
 * 	2������ÿһ���ֵ��
 * 	3���������е�value(��Բ�����)
 * @author Grant��Vranes
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("����", 99);
		map.put("��ѧ", 99);
		map.put("Ӣ��", 99);
		
		/*
		 * 	1)�������е�key
		 * 	Set<K> keySet() ����     key�������ظ�����Set����
		 * 	����ǰMap�����е�key��һ��Set������ʽ���ء�
		 * 	����������Ͼ͵�ͬ�ڱ��������е�key
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key+":"+map.get(key));
		}
		
		/*
		 * 	2)����ÿһ���ֵ��
		 * 	Set<Entry> entrySet() ����
		 * 
		 * 	java.util.Map.Entry
		 * 	Entry��ÿһ��ʵ�����ڱ�ʾ��ǰMap�е�һ���ֵ��.
		 * 	�������������õķ�����
		 * 	getKey(), getValue()�ֱ������ڻ�ȡ��Ӧ��
		 * 	key��value
		 */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for(Entry<String, Integer> e : entrySet) {
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * 	3)�������е�value
		 * 	Collection<K> values() ����
		 * 	value�����ظ�����Collection����
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values) {
			System.out.println("value:" + value);
		}
	}
}