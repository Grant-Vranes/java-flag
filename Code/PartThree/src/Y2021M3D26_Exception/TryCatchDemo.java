package Y2021M3D26_Exception;
/**
 * 	java异常处理机制中的try-catch
 * 	try语句块用来包含可能出错的代码片段，catch
 * 	用来捕获这些错误并针对该错误进行处理。
 * @author Grant·Vranes
 *
 */
public class TryCatchDemo {
	public static void main(String[] args) {
		System.out.println("program start");
		
		/*
		 * 	当JVM执行代码时发现 一个错误时，会根据错误实例化对应的异常实例，
		 * 	并将程序执行过程设置进去，然后将该异常在出错的语句位置抛出。
		 * 	之后try-catch处理，若没有则认为出错的语句所在的方法没有
		 * 	解决异常的能力，随之将异常抛出到该方法之外。
		 */
		try {
			String str = null;
			System.out.println(str.length());
			//try语句块中出错代码以下内容不执行
			System.out.println("不执行");
		}catch(NullPointerException e) {//括号中是可能出现的错误实例
			System.out.println("出现了空指针");
		}catch(StringIndexOutOfBoundsException e) {
			//通常情况下try中抛出的一场可能不止一个，所以catch可以写多个，但子异常一定要先捕获
			System.out.println("字符串下标越界了");
		}catch(Exception e) {
			/*	真实开发的时候，总有意想不到的错误，所以应当在最后一个catch处捕获
			 * 	Exception，尽量避免一个未捕获异常导致程序中断
			 * 	
			 */
			System.out.println("程序出错");
		}
		
		
		System.out.println("program end");
	}
}
