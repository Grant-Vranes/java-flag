package Y2021M3D17_string;
/**
 * 	ͼƬ������
 * @author Grant��Vranes
 *
 */
public class SplitTestDemo {
	public static void main(String[] args) {
		String imageName = "abc.jpg";
		imageName = imageRename(imageName);
		System.out.println(imageName);
		
		/*
		 * 	����ʹ�����·�ʽת��Ϊ����ʱ��
		 * 	long time = 1535078983390L;
		 * 	Date date = new Date(time);
		 * 	System.out.println(date);
		 */
	}
	
	public static String imageRename(String imageName) {
		//����"."���
		String[] data = imageName.split("\\.");
		imageName = System.currentTimeMillis()+"."+data[1];
		return imageName;
	}
}
