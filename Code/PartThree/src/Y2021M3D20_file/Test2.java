package Y2021M3D20_file;
/**
 *	���ڵݹ�˼��ĵ�С��Ŀ
 * 	1�����1+2+3+4+����+100,��������
 * 		���ÿ���ۼӽ��
 * 		��δ����в��ó���for��while�ؼ���
 * 	2��һ��Ǯ��1ƿ��ˮ��2����ƿ���Ի�1ƿ��ˮ
 * 		3��ƿ�ǿ��Ի�һƿ��ˮ���ʣ�20��Ǯ���տ��Եõ�����ƿ��ˮ
 * @author Grant��Vranes
 *
 */
public class Test2 {
	private static int count = 1;
	public static void main(String[] args) {
		System.out.println("1��ǰ100�������ۼӺͣ�" + add(0));
		System.out.println("2��20�������" + cal(20,20,20));
	}
	public static int add(int temp) {//�����tempһ�����ۻ��ĺ�
		int ans = temp;//ans�ǽ��
		if(count>=1 && count<=100) {
			ans += count;
			count++;
			ans = add(ans);
		}
		return ans;
	}
	public static int cal(int sum,int cap,int bottle){
		int add=cap/3+bottle/2;//ÿ��ѭ�������ӵ���ˮ
		sum=sum+add;
		System.out.println(sum);
		cap=cap%3+add;//ÿ��ѭ�����ƿ����
		System.out.println(cap);
		bottle=bottle%2+add;//ÿ��ѭ�����ƿ��
		System.out.println(bottle);
		System.out.println("-----------------");
		if(cap<3&&bottle<2){//�ݹ����������
			return sum;
		}else{
			return cal(sum,cap,bottle);//�ݹ����
		}
	}
}
