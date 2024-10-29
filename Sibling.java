import java.util.Scanner;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(){
        this.val=0;
        left=right=null;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class Sibling {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode root=buildTree();
        NotHaveSibling(root);
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(sc.nextInt());
        boolean hlc=sc.nextBoolean();
        if(hlc){
            root.left=buildTree();
        }

        boolean hrc=sc.nextBoolean();
        if(hrc){
            root.right=buildTree();
        }

        return root;
    }
    public static void NotHaveSibling(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null && root.right==null){
            System.out.print(root.left.val+" ");
        }
        if(root.right!=null && root.left==null){
            System.out.print(root.right.val+" ");
        }
        NotHaveSibling(root.left);
        NotHaveSibling(root.right);
    }
}
