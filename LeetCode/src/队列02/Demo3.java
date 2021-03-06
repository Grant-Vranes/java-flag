package 队列02;

/**
 * 希望你能修改二叉树里所有的 next 指针，使其指向右边的结点，如果右边没有结点，那么设置为空指针。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 例如：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo3 {

    public Node connect(Node root) {
        Node Q = null;
        if (root != null) {
            Q = root;
        }

        while (Q != null) {
            // 下一层前驱结点
            Node nextLevelPreNode = null;
            // 下一层的头结点
            Node nextLevelHead = null;
            // 顺序遍历当前层的每个结点
            Node curLevelNode = Q;
            while (curLevelNode != null) {
                // 如果得到一个下一层的结点
                if (curLevelNode.left != null) {
                    // 让下一层的前驱结点指向得到的下一层结点
                    if (nextLevelPreNode != null) {
                        nextLevelPreNode.next = curLevelNode.left;
                    }
                    nextLevelPreNode = curLevelNode.left;
                    // 设置下一层的头
                    if (nextLevelHead == null) {
                        nextLevelHead = curLevelNode.left;
                    }
                }
                // 如果得到一个下一层的结点
                if (curLevelNode.right != null) {
                    // 让下一层的前驱结点指向得到的下一层结点
                    if (nextLevelPreNode != null) {
                        nextLevelPreNode.next = curLevelNode.right;
                    }
                    nextLevelPreNode = curLevelNode.right;
                    // 设置下一层的头
                    if (nextLevelHead == null) {
                        nextLevelHead = curLevelNode.right;
                    }
                }
                curLevelNode = curLevelNode.next;
            }
            Q = nextLevelHead;
        }
        return root;
    }
}
//关于二叉树的定义
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
