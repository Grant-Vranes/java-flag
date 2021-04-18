package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	����ת��ΪList����
 * 	ͨ������ģ�Arrays�ľ�̬����asList����
 * 	��һ������ת��Ϊһ��List
 * 
 * 	ע�⣺ֻ������תList������תSet����ΪList��Set�ı���������
 * 	List���ظ���Set�����ظ���������������򲢲��������ߵ����𣩣�
 * 	һ�������п��ܻ����ظ�Ԫ�أ�����ֻ��תList
 * @author Grant��Vranes
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three"};
		//����һ����Ӧ�������͵ļ���
		List<String> list = Arrays.asList(array);
		System.out.println(list);//[one, two, three]
	
		/*
		 * 	����ת���ļ��϶���Ԫ�ز������Ƕ�ԭ�����ӦԪ�صĲ���
		 * 	����ʹ��set�����޸���list���Ϻ󣬶�Ӧ��ԭ����Ҳ����
		 * 	��Ӧ�仯��
		 * 
		 * 	ע�⣺asList����ֻ�ʺ�ת����List֮����ж�ȡ�Ļ���������
		 * 	��Ȼת��List�����ˣ����ǵײ���Ȼ�����飬ת����listֻ����
		 * 	������ȡ��������Ҫ�޸��ǲ��е�
		 */
		list.set(1, "2");
		System.out.println(list);//[one, 2, three]
		System.out.println("array:" + Arrays.toString(array));//array:[one, 2, three]
		
		/*
		 * 	���������Ƕ����ģ����Բ�֧�ּ��ϵ���ɾ��������Ȼ�ͻ��׳��쳣
		 * 	��Ϊ��ɾ�ͻ��ԭ�������ݻ������ݣ����䱾�ʾ��Ǵ���һ�������顣
		 */
		list.add("four");//UnsupportedOperationException
	
		/*
		 * 	������ת���ɼ��ϱ�����Ϊ�˲������㣬���ڲ�����ɾ����ʵ�����ٴ���һ
		 * 	�����ϣ�Ȼ���ת����ļ��ϸ�������
		 * 	���еļ��϶��ṩ��һ������ΪCollection�Ĺ��췽�����������ڴ���
		 * 	��ǰ���ϵ�ͬʱ�������������е�����Ԫ��
		 */
		List<String> list2 = new ArrayList<String>(list);
		/*
		 * 	������仰���൱��
		 * 	List<String> list2 = new ArrayList<String>();
		 * 	list2.addAll(list);
		 * 	Ȼ��Ϳ��ԶԼ�����ɾ
		 */
	}
}