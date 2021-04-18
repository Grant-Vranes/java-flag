package Y2021M4D10_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 	java.util.Map
 * 	Map ���ұ����ṹ����������һ���������еı���
 * 	���г�Ϊkey�����г�Ϊvalue
 * 	����Map������key-value�Ե���ʽ����Ԫ�ء�
 * 	�������Ǹ���keyȥ��ȡ��Ӧ��value
 * 	�Դ����Ǿ���������ѯ��������Ϊkey����Ҫ��ѯ������
 * 	��Ϊvalue���б��档
 * 	
 * 	Map������һ���ӿڣ��涨��Map��������ط�����
 * 	����ʵ���ࣺjava.util.HashMap
 * 
 * 	HashMap�ֳ�Ϊɢ�б�����ϣ��
 * 	ʹ��ɢ���㷨ʵ�ֵ�Map�����������ϲ�ѯ�ٶ��������ݽṹ
 * @author Grant��Vranes
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		/*	1)�淽��
		 *	V put(K k, V v)
		 *	��������һ���ֵ�Դ��뵽Map��
		 *
		 *	Map��һ��Ҫ�󣬼���key�������ظ���
		 *	�Ƿ��ظ�������key����equals�ȽϵĽ����
		 *	���ʹ��map�����е�key����value�������
		 *	���� Ϊ�滻value��������ô��ʱput�����Ὣ
		 *	���滻��value���ء�����������滻������
		 *	����ֵΪnull
		 */
		map.put("����", 99);
		map.put("��ѧ", 99);
		Integer d = map.put("Ӣ��", 99);
		/*
		 * 	���value�Ǹ���װ�࣬��ô����ʱӦ������ֱ��ʹ�û������͡�
		 * 	��Ϊ��ᵼ���Զ����䣬��û�����滻���������ص�value��Ϊ
		 * 	null����ʱ��null����������˿�ָ���쳣��
		 */
		System.out.println(d);//null
		System.out.println(map);//{��ѧ=99, ����=99, Ӣ��=99}
		
		//�滻�����ķ���ֵΪ���滻��value
		d = map.put("����",100);
		System.out.println(d);//99
		System.out.println(map);//{��ѧ=99, ����=100, Ӣ��=99}
	
	
		/*	2)��ȡ����
		 * 	V get(Object key)
		 * 	���ݸ�����key��ȡ��Ӧ��value����������key�����ڣ��򷵻�ֵΪnull
		 */
		d = map.get("��ѧ");
		System.out.println("��ѧ��"+ d);//��ѧ��99
		
		/*	3)Ԫ�أ���ֵ�ԣ�����
		 * 	int size()
		 * 	��ȡMap�е�Ԫ�ظ�����ÿ���ֵ����һ��Ԫ��
		 */
		int size = map.size();
		System.out.println("size:"+size);//size:3
		
		/*	4)ɾ������
		 * 	V remove(K k)
		 * 	��������key����Ӧ�ļ�ֵ��ɾ��������ֵΪ��key��Ӧ��value
		 */
		d = map.remove("����");
		System.out.println(map);//{��ѧ=99, Ӣ��=99}
		System.out.println(d);//100
	}
}