class TempTreeNode {
      int val;
      TempTreeNode left;
      TempTreeNode right;
      TempTreeNode() {}
      TempTreeNode(int val) { this.val = val; }
      TempTreeNode(int val, TempTreeNode left, TempTreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class Solution {

    static int max = -1;
    public static int diameterOfBinaryTree(TempTreeNode root) {
        recur(root);
        return max;
    }

    static int recur(TempTreeNode root) {
        if(root==null) {
            return -1;
        }
        System.out.println(root.val + " " + max);
        if(root.left==null && root.right==null) {
            return 0;
        }

        int left = recur(root.left);
        int right = recur(root.right);

        System.out.println(left + " " + right + " " + 
        root.val + " " + max + " " + (left+right+2));
        if(left+right+2>max) {
            max = left+right+2;
        }

        return 1 + Math.max(left, right);

    }

    public static void main(String[] args) {
        TempTreeNode node = new TempTreeNode(1);
        node.right = new TempTreeNode(2);
        System.out.println(diameterOfBinaryTree(node));
    }

}