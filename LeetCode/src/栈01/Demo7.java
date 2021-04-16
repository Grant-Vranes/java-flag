package 栈01;

import java.util.Arrays;
import java.util.Stack;

/**
 * 3.数组中元素左边离我最近且比我大的元素的位置
 * 输入[1, 2, 4, 9, 4, 0, 5]
 * 输出[-1, -1, -1, -1, 3, 4, 3]
 */
public class Demo7 {
    public static void main(String[] args) {
        int[] A = {1,2,4,9,4,0,5};
        System.out.println(Arrays.toString(findLeftBig(A)));
    }
    public static int[] findLeftBig(int[] A){
        //结果集
        int[] ans = new int[A.length];
        Stack<Integer> t = new Stack<>();
        //遍历数组
        for (int i = A.length-1; i >= 0; i--) {
            //获取当前遍历值
            final int x = A[i];
            while(!t.empty() && A[t.peek()] < x){
                ans[t.peek()] = i;
                t.pop();
            }
            t.push(i);
        }
        while(!t.empty()){
            ans[t.peek()] = -1;
            t.pop();
        }

        return ans;
    }

}
