package Y2021M2D21;
//���ַ���Ϸ
import java.util.Scanner;
public class Demo_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate();//��ȡ���µ��������
		while(true) {
			System.out.println("please guess");
			String str = scan.next().toUpperCase();//Сдת��д
			if(str.equals("EXIT")) {//�˳�
				System.out.println("exit");
				break;
			}
			char[] input = str.toCharArray();
			int[] result = check(chs,input);
			int wrongCount = 0;//�´����
			if(result[0] == chs.length) {//��
				int score = 100*chs.length-10*wrongCount;//
				System.out.println("��ϲ,�÷�:"+score);
			}else {
				wrongCount++;
				System.out.println("�ַ��Ը���:"+result[1]+" λ�öԸ���:"+result[0]);
			}
		}
	}
	
	//�����������
	public static char[] generate() {
		char[] chs = new char[5];//����ַ�����
		char[] letters = new char[] {'A','B','C','D','E','F'
				,'G','H','I','J','K','L','M','N','O','P','Q'
				,'R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];//��������
		for(int i = 0; i < chs.length; i++) {
			int index;
			do {
				index = (int)(Math.random()*letters.length);//�漴�±꣨0��25��
			}while(flags[index]);//��Ϊtrue˵������ַ��Ѿ����ɹ�����������
			chs[i] = letters[index];//�����������һ���ַ�����chs
			flags[index] = true;//��ѡ����������Ϊtrue���´β�����ѡ
		}
		return chs;
	}
	
	//�Աȣ��������chs���û�������ַ�����input
	public static int[] check(char[] chs,char[] input){
        int[] result = new int[2];//result[0]Ϊλ�öԼ�����result[1]Ϊ�ַ��Լ���
        for(int i = 0; i < chs.length; i++) {
        	for(int j = 0; j < input.length; j++) {
        		if(chs[i] == input[j]) {//�ַ���
        			result[1]++;
        			if(i == j) {//λ�ö�
        				result[0]++;
        			}
        			break;//�ҵ��˶�Ӧ�ģ�ʣ��input���ڲ���
        		}
        	}
        }
        return result;
     }
}
