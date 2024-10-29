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
public class RemoveLeaves {
    static Scanner sc = new Scanner(System.in); 
    public static void main(String[] args) {
        TreeNode root=buildTree();
        TreeNode tree=remove(root);
        Display(tree);
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
    public static TreeNode remove(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return null;
        }
        root.left=remove(root.left); 
        root.right=remove(root.right);
        return root;
    }
    public static void Display(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        Display(root.left);
        Display(root.right);
    }
    
}
