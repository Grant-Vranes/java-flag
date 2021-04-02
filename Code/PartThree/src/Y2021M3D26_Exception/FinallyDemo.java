package Y2021M3D26_Exception;
/**
 * finally块
 * finally是异常处理机制的的最后一块，可以直接跟在try之后或者最后一个catch之后。
 * finally可以确保只要程序运行到try语句块中，那么无论是否抛出异常，finally中的代码必定执行。
 * 	一般作用：不关心异常，一定要执行的代码，比如流的关闭。一般我们将释放资源的操作放在finlly中。
 * @author Grant·Vranes
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
			System.out.println("程序出错");
		}finally {
			//只要写了finally，并且return在try中包含，finally中的语句必然执行
			System.out.println("必定执行，return都不好使");
		}
		
		System.out.println("program end");
	}
}
