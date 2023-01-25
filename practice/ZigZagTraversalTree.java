import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
    class Pair {
        TreeNode node;
        int level;
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
 
class Solution {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<>();
        int depth = depth(root);
        for(int i=0; i<depth ; i++) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        queue.add(new Pair(root, 0));
        recur(result, queue);
        return result;
    }

    static int  depth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    static void recur(List<List<Integer>> result, Queue<Pair> queue) {
        if(queue.isEmpty()) {
            return ;
        }

        Pair current = queue.remove();

        result.get(current.level).add(current.node.val);
        if(current.level%2==0) {
            if(current.node.right!=null) {
                queue.add(new Pair(current.node.right, current.level+1));
            }
            if(current.node.left!=null) {
                queue.add(new Pair(current.node.left, current.level+1));
            }
        } else {
            if(current.node.left!=null) {
                queue.add(new Pair(current.node.left, current.level+1));
            }
            if(current.node.right!=null) {
                queue.add(new Pair(current.node.right, current.level+1));
            }
        }
        recur(result, queue);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(node));
    }


}