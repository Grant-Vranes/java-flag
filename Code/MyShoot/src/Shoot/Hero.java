package Shoot;

public class Hero extends FlyingObject{
		// ��Ա����
		int life;//����
		int doubleFire;//����ֵ
		//���췽��
		Hero(){
			/*
			//thisָ����������
			//superָ���ǳ���
			super.width = 97;//��thisҲ����
			super.height = 124;
			super.x = 140;
			super.y = 400;
			*/
			super(97,124,140,400);
			this.life = 3;
			this.doubleFire = 0;
		}
		// Ӣ�ۻ��л�ͼƬ
		void step() {
			x = 140;//Ӣ�ۻ���ʼλ��
			y = 140;
			life = 3;
			doubleFire = 0;//��������
		}
		
		//Ӣ�ۻ�������ƶ���x/y��������
		void moveTo(int x,int y) {
			
		}
}