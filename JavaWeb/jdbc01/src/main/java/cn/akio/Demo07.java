package cn.akio;

import java.sql.Connection;
/**
 * 线程中详述连接池的等待问题
 * @author Grant·Vranes
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		DemoThread d1 = new DemoThread();
		d1.start();
		DemoThread d2 = new DemoThread();
		d2.start();
		DemoThread d3 = new DemoThread();
		d3.start();
		DemoThread d4 = new DemoThread();
		d4.start();
			
	}
}

class DemoThread extends Thread {
	@Override
	public void run() {
		//获取连接
		try {
			Connection conn = DBUtils.getConn();
			System.out.println("得到连接");
			//模拟耗时
			Thread.sleep(5000);
			//归还连接
			conn.close();
			System.out.println("归还连接");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}