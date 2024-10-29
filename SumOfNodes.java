import java.util.*;
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
public class SumOfNodes {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode root=buildTree();
        int sum=SumNodes(root);
        System.out.print(sum);
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
    public static int SumNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int ls=SumNodes(root.left);
        int rs=SumNodes(root.right);
        return ls+rs+root.val;
    }
    
}
