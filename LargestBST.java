// import java.util.Scanner;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

static class Info {
    int size;   // Size of the subtree
    int max;    // Maximum value in the subtree
    int min;    // Minimum value in the subtree
    boolean isBST;  // Is this subtree a BST

    Info(int size, int min, int max, boolean isBST) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

public class LargestBST {
    static int idx=0;
    static int maxSize = 0; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] preorder=new int[n];
        for(int i=0;i<n;i++){
            preorder[i]=sc.nextInt();
        }
        int[] inorder=new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        TreeNode root=BuildTree(0,n-1,preorder,inorder);
        largest(root);
    }
    public static TreeNode BuildTree(int start,int end,int[] pre,int[] In){
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(pre[idx]);
        idx++;
        if (start == end) {
            return node;
        }
        int i;
        for (i = start; i <= end; i++) {
            if (In[i] == node.val) {
                break;
            }
        }
        node.left = BuildTree(start, i - 1,pre,In);
        node.right =BuildTree(i + 1, end,pre,In);
        return node;
    }

    public static Info largest(TreeNode root) {
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        Info left = largest(root.left);
        Info right = largest(root.right);
        if (left.isBST && right.isBST && left.max < root.val && right.min > root.val) {
            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size); 
            return new Info(size, Math.min(left.min, root.val), Math.max(right.max, root.val), true);
        }
        return new Info(0, 0, 0, false);
    }

}
