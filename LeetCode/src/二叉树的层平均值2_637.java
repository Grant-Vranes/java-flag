import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值2_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        // 生成FIFO队列
        Queue<TreeNode> Q = new LinkedList<>();
        // 如果结点不为空，那么加入到FIFO队列
        //注意：并不是一下把树中所有的元素都放进去了，而是一层一层的放
        if (root != null) {
            Q.offer(root);
        }
        // ans用于保存层次遍历的结果,结果集
        List<Double> ans = new LinkedList<>();
        // 开始利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 取出当前层里面元素的个数
            final int qSize = Q.size();
            double tmp = 0;
            // 遍历当前层的每个结点
            for (int i = 0; i < qSize; i++) {
                // 当前层前面的结点先出队
                TreeNode cur = Q.poll();
                // 把结果累加到tmp中
                tmp += cur.val;
                // 把下一层的结点入队，注意入队时需要非空才可以入队。
                if (cur.left != null) {
                    Q.offer(cur.left);
                }
                if (cur.right != null) {
                    Q.offer(cur.right);
                }
            }
            // 把当前层的结果放到返回值里面。
            tmp /= qSize;
            ans.add(tmp);
        }
        return ans;
    }
}
