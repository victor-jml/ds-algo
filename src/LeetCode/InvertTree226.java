import binarytree.TreeNode;

/**
 * @Author: zy
 * @Date: 2020/11/2 22:47
 * @Description:
 */
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
