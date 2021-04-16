package 栈01;

import java.util.Stack;

/**
 * 给定一个数组，数组中的元素代表木板的高度。请你求出相邻木板能剪出的最大矩形面积。
 * 输入[2,1,5,6,2,3]
 * 输出10
 */
public class Demo9 {
    public static void main(String[] args) {
        int[] A = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(A));
    }
    /**
     * 思路1：
     * 在选择的时候，由于要构造出最大的矩形。一种暴力的做法是：
     * for (int i = 0; i < N; i++) {
     *     ans = max(ans, A[i]参与构造的最大矩形面积);
     * }
     * 那么在求A[i]参与构造的最大矩形的时候。A[i]左边与右边的值
     * 肯定都要 >= A[i]才可以。
     *
     * 那么也就是说，我们需要找到左边第一个比A[i]小的数, leftPos
     * 也需要找到右边第一个比A[i]小的数。rightPos
     *
     * 那么前面暴力的代码就可以写成：
     *
     * for (int i = 0; i < N; i++) {
     *     leftPos = findLeftSmall(A[i]);
     *     rightPos = findRightSmall(A[i]);
     *     ans = max(ans, A[i] * (rightPos - leftPos - 1));
     * }
     *
     * 而leftPos和rightPos我们都可以先通过单调栈得到。那么到这里，问题就解决了。
     */
    public static int largestRectangleArea(int[] A) {
        final int N = A == null ? 0 : A.length;

        int[] leftSmall = LeftSmall.findLeftSmall(A);
        int[] rightSmall = RightSmall.findRightSmall(A);

        int ans = 0;

        for (int i = 0; i < N; i++) {
            final int height = A[i];
            // 左边比我小的位置
            // 右边比我小的位置
            final int leftPos = leftSmall[i];
            final int rightPos = rightSmall[i] == -1 ? N : rightSmall[i];

            // 现在我们确定区间(leftPos, rightPos)
            // 注意两边都是开区间。在这个区间里面，所有的数肯定都是 >= A[i]的。
            // 那么底部的宽度就是
            final int width = rightPos - leftPos - 1;
            final int area = height * width;

            ans = Math.max(ans, area);
        }
        return ans;
    }
}

class LeftSmall {
    // 当我们要找左边比我小的元素的时候，需要用递增栈
    public static int[] findLeftSmall(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标
        Stack<Integer> t = new Stack<>();

        // 注意这里的遍历方向发生了变化，因为我们是要找到左边比我小的元素的位置
        for (int i = A.length - 1; i >= 0; i--) {
            final int x = A[i];
            // 每个元素都遍历栈中的元素完成消除动作
            // 这里是递减栈
            // 如果发现进来的元素x与栈中元素相比
            // 如果大于栈中的元素，那么要把栈中的元素弹出去
            while (!t.empty() && A[t.peek()] > x) {
                // 消除的时候，记录一下被谁消除了
                ans[t.peek()] = i;
                // 消除时候，值更大的需要从栈中消失
                t.pop();
            }
            // 剩下的入栈
            t.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!t.empty()) {
            ans[t.peek()] = -1;
            t.pop();
        }

        return ans;
    }
}

class RightSmall {
    public static int[] findRightSmall(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标
        Stack<Integer> t = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            // 每个元素都向左遍历栈中的元素完成消除动作
            while (!t.empty() && A[t.peek()] > x) {
                // 消除的时候，记录一下被谁消除了
                ans[t.peek()] = i;
                // 消除时候，值更大的需要从栈中消失
                t.pop();
            }
            // 剩下的入栈
            t.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!t.empty()) {
            ans[t.peek()] = -1;
            t.pop();
        }

        return ans;
    }
}