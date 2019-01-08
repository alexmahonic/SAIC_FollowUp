class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class CountCompleteTreeNodes {

    private int countNodes(TreeNode root) {
        //divide and conquer idea
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if (leftDepth == rightDepth)
            return (1 << leftDepth) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);

    }

    // calculate left depth of the root
    private int leftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    // calculate right depth of the root
    private int rightDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }

    public static void main(String[] arg) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        int res = countCompleteTreeNodes.countNodes(root);
        System.out.println(res);
    }

}


