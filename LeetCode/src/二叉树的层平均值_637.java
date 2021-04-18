import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * 提示：
 * 节点值的范围在32位有符号整数范围内。
 */
//原始想法
public class 二叉树的层平均值_637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        //定义结果集
        List<Double> result = new LinkedList<>();

        //生成FIFO队列，队列中存储的是TreeNode类型的数据
        Queue<TreeNode> Q = new LinkedList<>();
        //如果节点不为空，那么加入FIFO队列
        //注意：并不是一下把树中所有的元素都放进去了，而是一层一层的放
        if (root != null) {
            Q.offer(root);//入队
        }

        //开始使用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            //取出当前层里面的元素个数
            final int qSize = Q.size();
            //当前层的结果存放于tmp链表中
            List<Integer> tmp = new LinkedList<>();//每一次遍历获得的都是每一层的数据元素
            //遍历当前层的每个节点
            for (int i = 0; i < qSize; i++) {
                //当前层前面的先出队
                TreeNode cur = Q.poll();
                //把结果存放于当前层中
                tmp.add(cur.val);
                //把下一层的节点入队，注意入队时需要左右子节点非空才可以入队
                if(cur.left != null){
                    Q.offer(cur.left);
                }
                if(cur.right != null){
                    Q.offer(cur.right);
                }
            }
            //将求出的平均值存入结果集
            double sum = 0.0;
            for(Integer v : tmp){
                sum += v;
            }
            result.add(sum/tmp.size());
        }
        return result;
    }
}