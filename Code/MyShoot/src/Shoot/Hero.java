package Shoot;
import java.awt.image.BufferedImage;

/*Ӣ�ۻ���*/
public class Hero extends FlyingObject{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[2];
		images[0] = loadImage("hero0.png");
		images[1] = loadImage("hero1.png");
	}
	// ��Ա����
	private int life;//����
	private int doubleFire;//����ֵ
	
	/*���췽��*/
	public Hero(){
		/*
		thisָ����������
		superָ���ǳ���
		super.width = 97;//��thisҲ����
		super.height = 124;
		super.x = 140;
		super.y = 400;
		*/
		super(97,139,140,400);
		this.life = 3;
		this.doubleFire = 0;
	}
	
	/* Ӣ�ۻ���ʼ��*/
	public void step() {
		
	}
	
	/*Ӣ�ۻ�������ƶ���x/y��������*/
	public void moveTo(int x,int y) {
		this.x = x-this.width/2;//Ӣ�ۻ���x=����x-1/2Ӣ�ۻ��Ŀ�;Ӣ�ۻ���(x,y)����Ӣ�ۻ�ͼƬ�����Ͻ�
		this.y = y-this.height/2;//Ӣ�ۻ���y=����y-1/2Ӣ�ۻ��ĸ�
	}
	
	int index = 0;//�±�
	/*��дgetImage()*/
	public BufferedImage getImage() {
		if(isLife()) {
			return images[index++%images.length];//������ͼƬ�������л�
		}
		return null;
	}
	
	/*Ӣ�ۻ������ӵ��������ӵ���*/
	public Bullet[] shoot() {
		int xStep = this.width/4;//1/4Ӣ�ۻ��Ŀ�
		int yStep = 20;//�̶���ֵ���ӵ��ĳ��ȣ�
		if(doubleFire > 0) {//˫���������ӵ�λ�ڷɻ�ǰ������
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x+1*xStep,y-yStep);//x:Ӣ�ۻ���x+1/4Ӣ�ۻ��Ŀ�  y:Ӣ�ۻ���y-�̶���ֵ
			bs[1] = new Bullet(this.x+3*xStep,y-yStep);//x:Ӣ�ۻ���x+3/4Ӣ�ۻ��Ŀ�  y:Ӣ�ۻ���y-�̶���ֵ
			doubleFire -= 2;//����һ��.˫������-2
			return bs;
		}else {//�����������ӵ�λ�ڷɻ�ǰ���м�
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x+2*xStep,y-yStep);//x:Ӣ�ۻ���x+1/4Ӣ�ۻ��Ŀ�  y:Ӣ�ۻ���y-�̶���ֵ
			return bs;
		}
	}
}
