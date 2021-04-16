package 栈01;

import java.util.Stack;

/**
 * 给定一个数组，数组中的元素代表木板的高度。请你求出相邻木板能剪出的最大矩形面积。
 * 输入[2,1,5,6,2,3]
 * 输出10
 */
public class Demo10 {
    public static void main(String[] args) {
        int[] A = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(A));
    }
    /*
     * 思路：
     * 2个重要的性质：
     *
     * 一个递增栈里面存放的是数组的下标 stack = [i, j]
     *
     * 性质1: 对于j而言，下标[i+1 ... j-1] 这里面的元素的A[x]值都 >= A[j]
     *       对于i而言，(-1, i-1] 这里面元素的值都 >= A[i];
     *
     * 如果此时A[k]要入栈。并且A[k] < A[j]，要将A[j]出栈。
     *
     * 性质2: A[j+1 ... k-1]这个区间里面的元素都大于A[j]
     *
     */
    public static int largestRectangleArea(int[] A) {
        final int N = (A == null ? 0 : A.length);

        // 虽然可以用Stack<Integer>，但是这里我们为了更快地操作，我们用
        // 数组模拟栈来运行，因为我们知道最多存放的内容实际上就是N个
        int top = 0;
        // s[top-1]表示栈顶元素
        int[] s = new int[N];

        int ans = 0;

        // 注意，这里我们取到了i == N
        // 按理说，不应该取到i == N的。但是这时候，主要是为了处理这种数组
        // A = [1, 2, 3]
        // 没有任何元素会出栈。
        // 那么最后我们用一个0元素，把所有的元素都削出栈。
        // 这样代码就可以统一处理掉。
        for (int i = 0; i <= N; i++) {
            // 注意：当i == N的时候，x = -1;
            // 比数组中的元素都要小。
            final int x = i == N ? -1 : A[i];
            while (top > 0 && A[s[top - 1]] > x) {
                // 计算以A[s[top]]的元素的高度的矩形。
                final int height = A[s[--top]];
                // i元素要将index = s[top-1]的元素出栈。
                // 那么根据性质2：
                // 此时A[s[top-1] .... i) 这个区间里面的元素都是
                // 大于A[s[top-1]]的
                final int rightPos = i;
                // 这里需要使用性质1.
                // 注意：当栈中一个元素都没有的时候，要取-1
                final int leftPos = top > 0 ? s[top - 1] : -1;
                final int width = rightPos - leftPos - 1;
                final int area = height * width;
                ans = Math.max(ans, area);
            }

            s[top++] = i;
        }

        return ans;
    }

}
