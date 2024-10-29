import java.util.*;
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
        this.left=this.right=null;
    }
}
public class BalanceBT {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode root=buildTree();
        boolean ans=IsBalanced(root);
        System.out.println(ans);
    }
    public static TreeNode buildTree(){
        int item=sc.nextInt();
        TreeNode root=new TreeNode(item);

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
    public static boolean IsBalanced(TreeNode root){
        if(root==null){
            return true;
        }

        int lf=depth(root.left);
        int rf=depth(root.right);

        if(Math.abs(lf-rf)>1){
            return false;
        }
        boolean lb=IsBalanced(root.left);
        boolean rb=IsBalanced(root.right);
        return lb&&rb;
    }
    public static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=depth(root.left);
        int rh=depth(root.right);
        return Math.max(lh,rh)+1;
    }
    
}
