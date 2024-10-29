import java.util.*;
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
        this.left=this.right=null;
    }
}
public class Identical{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode root1=buildTree();
        TreeNode root2=buildTree();
        boolean res=IsSame(root1,root2);
        System.out.println(res);
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
    public static boolean IsSame(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1 == null || root2==null){
            return false;
        }
        return (root1.val==root2.val) && IsSame(root1.left, root2.left) && IsSame(root1.right, root2.right);
    }
   
}