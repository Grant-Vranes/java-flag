package Y2021M3D26_Exception;
/**
 * 	�쳣�����ĳ���Api
 * @author Grant��Vranes
 *
 */
public class ExceptionApiDemo {
	public static void main(String[] args) {
		try {
			String str = "A";
			System.out.println(Integer.parseInt(str));
		}catch(Exception e) {
			//���������Ϣ�����
			e.printStackTrace();
			//��ȡ������Ϣ
			String message = e.getMessage();
			System.out.println(message);//For input string: "A"
		}
		System.out.println("program end");
	}
}