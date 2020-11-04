import binarytree.TreeNode;

/**
 * @Author: zy
 * @Date: 2020/11/4 18:48
 * @Description:
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return solution(root,root.left,root.right);
    }

    public boolean solution(TreeNode root,TreeNode left,TreeNode right){
        if(root == null){
            return true;
        }
        if(left == null || right == null){
            return left == null && right == null;
        }
        return left.val == right.val && solution(root,left.right,right.left) && solution(root,left.left,right.right);
    }
}
