package Y2021M2D28;
//引用类型数组的演示
public class RefArrayDemo {
	public static void main(String[] args) {
		Student[] stus = new Student[3];
		stus[0] = new Student("A",25,"A","A018");
		stus[1] = new Student("B",25,"B","A018");
		stus[2] = new Student("C",25,"C","A018");
		System.out.println(stus[1].age);
		stus[2].sayHi();
		
		Student[] ss = new Student[] {
			new Student("A",25,"A","A018"),
			new Student("B",25,"B","A018"),
			new Student("C",25,"C","A018")
		};
		
		int[][] arr = new int[3][4];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = (int)(Math.random()*100);
		    }
		}
	}
}
