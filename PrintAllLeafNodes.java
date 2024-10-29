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
public class PrintAllLeafNodes {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode root=buildTree();
        PrintLeaf(root);
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
    public static void PrintLeaf(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.print(root.val+" ");
        }
        PrintLeaf(root.left);
        PrintLeaf(root.right);
    }
}

