package Y2021M3D1;
import Y2021M2D28.*;//������һ�����е���������
//�������͵�Ӧ��
public class Test {
	public static void main(String[] args) {
		/*
		Student[] ss = new Student[] {
				new Student("1",19,"����","A1608"),
				new Student("2",21,"����","A1609"),
				new Student("3",20,"����","A1608")
		};
		for(Student v : ss) {
			v.sayHi();
		}
		
		Teacher[] ts = new Teacher[] {
				new Teacher("1",19,"����",9800),
				new Teacher("2",21,"����",8900),
				new Teacher("3",20,"����",10000)
		};
		for(Teacher v : ts) {
			v.sayHi();
		}
		
		Doctor[] ds = new Doctor[] {
				new Doctor("1",19,"����",1),
				new Doctor("2",21,"����",2),
				new Doctor("3",20,"����",3)
		};
		for(Doctor v : ds) {
			v.sayHi();
		}
		*/
		
		Person[] ps = new Person[3];
		ps[0] = new Student("ѧ��",19,"����","A1608");//���ĸ�����ʹ��sayHi()�����Ͳ��ܷ���
		ps[1] = new Teacher("��ʦ",19,"����",9800);
		ps[2] = new Doctor("ҽ��",19,"����",1);
		
		for(Person v : ps) {
			v.sayHi();//ע�⣬sayHi()�ǳ����еķ�����ֻ�ܷ�����������еĳ�Ա����������������Student��Teacher��Doctor�еĳ�Ա�������ܷ���
		}
	}
}
