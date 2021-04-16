package 栈01;

import java.util.Arrays;
import java.util.Stack;

/**
 * 1.数组中右边第一个比我大的元素的位置
 * 输入[1, 2, 4, 9, 4, 0, 5]
 * 输出[1, 2, 3, -1, 6, 6, -1]
 */
public class Demo5 {
    public static void main(String[] args) {
        int[] A = {1,2,4,9,4,0,5};
        System.out.println(Arrays.toString(findRightBig(A)));
    }
    public static int[] findRightBig(int[] A) {
        // 结果数组,与A的索引位置一一对应
        int[] ans = new int[A.length];

        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            while(!t.empty() && A[t.peek()] < x){
                ans[t.peek()] = i;
                t.pop();
            }
            t.push(i);
        }
        while (!t.empty()) {
            ans[t.peek()] = -1;
            t.pop();
        }
        return ans;
    }
}
