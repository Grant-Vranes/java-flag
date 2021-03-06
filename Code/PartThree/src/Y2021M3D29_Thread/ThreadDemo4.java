package Y2021M3D29_Thread;
/**
 * 	线程提供了获取自身信息的相关方法
 * @author Grant·Vranes
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		//获取线程的名字
		String name = main.getName();
		System.out.println("name:"+name);
		
		//获取线程的唯一标识(id)
		long id = main.getId();
		System.out.println("id:"+id);
		
		//获取线程的优先级
		int priority = main.getPriority();
		System.out.println("优先级："+priority);
		
		//线程是否还处于活动状态
		boolean isAlive = main.isAlive();
		System.out.println("isAlive:"+isAlive);
		
		//线程是否被中断了
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
		
		//线程是否为守护线程
		boolean isDaemon = main.isDaemon();
		System.out.println("isDaemon"+isDaemon);
	
	}
}
