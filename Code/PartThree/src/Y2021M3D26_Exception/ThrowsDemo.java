package Y2021M3D26_Exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 	重写超类含有throws声明异常抛出的方法时，对throws的重写规则
 * @author Grant·Vranes
 *
 */
public class ThrowsDemo {//父类
	public void dosome() throws IOException,AWTException{
	}
}

class Son extends ThrowsDemo{//子类
	//正常抛出所有父类中的异常
//	public void dosome() throws IOException,AWTException{
//	}

	//允许仅抛出部分异常
//	public void dosome() throws IOException{
//	}
	
	//允许不再抛出任何异常
//	public void dosome(){
//	}
	
	//允许抛出超类方法抛出异常的子类型异常
//	public void dosome() throws FileNotFoundException{
//	}
	
	//不允许抛出额外异常
//	public void dosome() throws SQLException{
//	}
	
	//不允许抛出超类方法抛出异常的父类型异常
//	public void dosome() throws Exception{
//	}
	
}