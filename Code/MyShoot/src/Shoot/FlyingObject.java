package Shoot;
//������
public class FlyingObject {
	int width;
	int height;
	int x;
	int y;
	//����speed�������г�Ա���еģ�Ӣ�ۻ�û�С�
	
	//�������ƶ�
	void step() {
		System.out.println("�������ƶ�");
	}
	
	//ר�Ÿ�С�л�����л���С�۷��ṩ��
	FlyingObject(int width, int height){
		this.width = width;
		this.height = height;
		x = (int)(Math.random()*(400-this.width));//x��0�������ڿ�-С�л�����֮�������� 
		/*Ҳ������ôд
		 * Random rand = new Random();
		 * x = rand.nextInt(400-this.width);
		 */
		y = -this.height;//y:����С�л�����л���С�۷�ĸ߶�
	}
	
	//ר�Ÿ�Ӣ�ۻ�����ա��ӵ��ṩ
	FlyingObject(int width, int height, int x, int y){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
}