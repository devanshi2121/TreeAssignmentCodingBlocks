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
public class PreInorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] pre=new int[n];
        for(int i=0;i<n;i++){
            pre[i]=sc.nextInt();
        }

        int m=sc.nextInt();
        int[] In=new int[m];
        for(int i=0;i<n;i++){
            In[i]=sc.nextInt();
        }

        TreeNode root=MakeTree(pre,In,0,n-1);
        Display(root);
    }
    static int idx=0;
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
        idx++;
        root.left=MakeTree(pre, In, start, i-1);
        root.right=MakeTree(pre, In, i+1, end);
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
