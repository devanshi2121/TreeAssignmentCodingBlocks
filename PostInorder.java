package CreateTree;
import java.util.Scanner;
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
        this.left=this.right=null;
    }
}
public class PostInorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] post=new int[n];
        for(int i=0;i<n;i++){
            post[i]=sc.nextInt();
        }

        int m=sc.nextInt();
        int[] In=new int[m];
        for(int i=0;i<n;i++){
            In[i]=sc.nextInt();
        }
        idx=n-1;
        TreeNode root=MakeTree(post,In,0,n-1);
        Display(root);
    }
    static int idx;
    public static TreeNode MakeTree(int[] pre,int In[],int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(pre[idx]);
        int i=start;
        for(;i<=end;i++){
            if(In[i]==root.val){
                break;
            }
        }
        idx--;
        root.right=MakeTree(pre, In, i+1, end);
        root.left=MakeTree(pre, In, start, i-1);
        return root;
    }
    public static void Display(TreeNode root){
        if(root==null){
            return;
        }
        String str="";
        if(root.left!=null){
            str+=root.left.val;
        } 
        else{
            str+="END";
        }
        str+="=>"+root.val+"<=";
        
        if(root.right!=null){
            str+=root.right.val;
        } 
        else{
            str+="END";
        }
        System.out.println(str);
        Display(root.left);
        Display(root.right);
    }
    
}
