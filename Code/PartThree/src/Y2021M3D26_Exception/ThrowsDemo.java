package Y2021M3D26_Exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 	��д���ຬ��throws�����쳣�׳��ķ���ʱ����throws����д����
 * @author Grant��Vranes
 *
 */
public class ThrowsDemo {//����
	public void dosome() throws IOException,AWTException{
	}
}

class Son extends ThrowsDemo{//����
	//�����׳����и����е��쳣
//	public void dosome() throws IOException,AWTException{
//	}

	//������׳������쳣
//	public void dosome() throws IOException{
//	}
	
	//�������׳��κ��쳣
//	public void dosome(){
//	}
	
	//�����׳����෽���׳��쳣���������쳣
//	public void dosome() throws FileNotFoundException{
//	}
	
	//�������׳������쳣
//	public void dosome() throws SQLException{
//	}
	
	//�������׳����෽���׳��쳣�ĸ������쳣
//	public void dosome() throws Exception{
//	}
	
}