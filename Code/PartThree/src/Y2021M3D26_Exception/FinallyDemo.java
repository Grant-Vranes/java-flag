package Y2021M3D26_Exception;
/**
 * finally��
 * finally���쳣������Ƶĵ����һ�飬����ֱ�Ӹ���try֮��������һ��catch֮��
 * finally����ȷ��ֻҪ�������е�try�����У���ô�����Ƿ��׳��쳣��finally�еĴ���ض�ִ�С�
 * 	һ�����ã��������쳣��һ��Ҫִ�еĴ��룬�������Ĺرա�һ�����ǽ��ͷ���Դ�Ĳ�������finlly�С�
 * @author Grant��Vranes
 *
 */
public class FinallyDemo {
	public static void main(String[] args) {
		System.out.println("program start");
		try {
			String str = "";
			System.out.println(str.length());
			return;
		}catch(Exception e) {
			System.out.println("�������");
		}finally {
			//ֻҪд��finally������return��try�а�����finally�е�����Ȼִ��
			System.out.println("�ض�ִ�У�return������ʹ");
		}
		
		System.out.println("program end");
	}
}
