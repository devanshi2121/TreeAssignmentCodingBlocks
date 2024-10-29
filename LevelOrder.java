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

public class LevelOrder {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // If no integer is available as input, exit early
        if (!sc.hasNextInt()) {
            return;
        }

        TreeNode root = buildTree();
        levelOrder(root);
    }

    public static TreeNode buildTree() {
        if (!sc.hasNextInt()) {
            return null;
        }
        int data = sc.nextInt();
        TreeNode root = new TreeNode(data);

        boolean hasLeft = sc.nextBoolean(); // true if left node exists
        if (hasLeft) {
            root.left = buildTree();
        }

        boolean hasRight = sc.nextBoolean(); // true if right node exists
        if (hasRight) {
            root.right = buildTree();
        }

        return root;
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> ls = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                ls.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // Print the current level
            for (int item : ls) {
                System.out.print(item + " ");
            }
            System.out.println(); // Move to the next line for the next level

        }

    }
}
