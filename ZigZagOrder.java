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
public class ZigZagOrder {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TreeNode root=BuildTree();
        ZigZag(root);
    }
    public static TreeNode BuildTree(){
        int data=sc.nextInt();
        TreeNode root=new TreeNode(data);
        boolean hlc=sc.nextBoolean();
        if(hlc){
            root.left=BuildTree();
        }
        boolean hrc=sc.nextBoolean();
        if(hrc){
            root.right=BuildTree();
        }
        return root;
    }
    public static void ZigZag(TreeNode root){
        if(root==null){
            return;
        }
        List<Integer> ls1=new ArrayList<>();
        boolean flag=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(flag){
                    ls.add(node.val);
                }
                else{
                    ls.add(0,node.val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ls1.addAll(ls);
        }
    }
}
