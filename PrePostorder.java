package CreateTree;

import java.util.Scanner;

public class PrePostorder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] post=new int[n];
        for(int i=0;i<n;i++){
            post[i]=sc.nextInt();
        }

        int m=sc.nextInt();
        int[] pre=new int[m];
        for(int i=0;i<n;i++){
            pre[i]=sc.nextInt();
        }
        idx=0;
        TreeNode root=MakeTree(post,pre,0,n-1);
        Display(root);
    }
    static int idx;
    public static TreeNode MakeTree(int[] post,int pre[],int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(post[idx]);
        idx++;
        int i;
        for (i = start; i <= end; i++){
            if (post[i] == pre[idx])
                break;
        }
        if (i <= end){
            root.left = MakeTree(post,pre, start, i);
            root.right = MakeTree(post,pre, i + 1, end);
        }
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
