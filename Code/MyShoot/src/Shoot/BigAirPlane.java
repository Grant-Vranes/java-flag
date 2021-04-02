package Shoot;

import java.awt.image.BufferedImage;

/*��л�*/
public class BigAirPlane extends FlyingObject implements Enemy{
	private static BufferedImage[] images;
	private static BufferedImage[] boms;
	static {
		images = new BufferedImage[2];
		for(int i=0; i<images.length; i++) {
			images[i] = loadImage("bigairplane"+i+".png");
		}
		//��ը��
		boms = new BufferedImage[4];
		for (int i = 0; i < boms.length; i++) {
			boms[i] = loadImage("bom"+i+".png");
		}	
	}
	private int speed;//�ƶ��ٶ�
	
	/*���췽��*/
	public BigAirPlane() {
		super(66,89);
		speed = 2;//��л��ٶ�
		//System.out.println("��л�������");
	}
	
	/*�ƶ�*/
	public void step() {
		y += speed;//(����)
	}
	
	int index = 0;//�±�
	/*��дgetImage()*/
	public BufferedImage getImage() {
		if(isLife()) {
			return images[0];
		}else if(isDead()){
			BufferedImage bom = boms[index++];
			if(index == boms.length) {//����ը��͸���ʧ��
				state = REMOVE;
			}
			return bom;
		}
		return null;
	}
	
	/*��дgetScore()�÷�*/
	public int getScore() {
		return 3;//�����л�����ҵ�3��
	}
}
