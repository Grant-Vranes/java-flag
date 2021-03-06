package Y2021M3D26_Exception;
/**
 * 	异常处理的常用Api
 * @author Grant·Vranes
 *
 */
public class ExceptionApiDemo {
	public static void main(String[] args) {
		try {
			String str = "A";
			System.out.println(Integer.parseInt(str));
		}catch(Exception e) {
			//输出错误信息，最常用
			e.printStackTrace();
			//获取错误消息
			String message = e.getMessage();
			System.out.println(message);//For input string: "A"
		}
		System.out.println("program end");
	}
}
