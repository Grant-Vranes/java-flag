package Y2021M3D26_Exception;
/**
 * 	�Զ����쳣��ͨ��������˵����ǰ��Ŀ��ĳ��ҵ���߼�����
 * 
 * 	�˳�����ǹ������䲻�Ϸ��쳣���Զ���
 * @author Grant��Vranes
 *
 */
public class IllegalAgeException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	//���·�������ͨ���Ҽ�source->Generate Constructors from Superclass
	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
