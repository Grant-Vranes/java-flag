import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 * ​   3
 * ​  / \
 *  9  20
 * ​   / \
 *   15  7
 * 返回其层序遍历结果：
 *
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 */
public class 二叉树的层序遍历_102 {
   //定义这种类型
    public List<List<Integer>> levelOrder(TreeNode root) {
        //生成FIFO队列，队列中存储的是TreeNode类型的数据
        Queue<TreeNode> Q = new LinkedList<>();
        //如果节点不为空，那么加入FIFO队列
        //注意：并不是一下把树中所有的元素都放进去了，而是一层一层的放
        if (root != null) {
            Q.offer(root);//入队
        }
        //ans用于保存层次遍历的结果
        List<List<Integer>> ans = new LinkedList<>();
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
            //把当前层的结果放到返回值里面
            ans.add(tmp);
        }
        return ans;
    }

}
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}