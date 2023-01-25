import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.left = left;
		this.right = right;
	}
}

class AllBst {
	static void solution(int n) {
		List<TreeNode> result = new ArrayList<>(); 
		recur(null, new int[n], n, result);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).val);
		}
	}

	static void recur(TreeNode head, int[] visited, int count, List<TreeNode> result) {
		if(count==0) {
			result.add(head);
		}
		for(int i=0; i<visited.length; i++) {
			if(visited[i]==0) {
				visited[i]=1;
				TreeNode copy = deepCopy(head);
				copy = insert(copy, i+1);
				recur(copy, visited, count-1, result);
				visited[i]=0;
			}
		}
	}

	static TreeNode insert(TreeNode head, int i) {
		if(head==null) {
			return new TreeNode(i);
		} 
		if(head.val<i) {
			insert(head.right, i);
		} else {
			insert(head.left, i);
		}
		return head;
	}

	static TreeNode deepCopy(TreeNode head) {
		if(head==null) {
			return null;
		}
		TreeNode deepCopy = new TreeNode(head.val);
		deepCopy.left = deepCopy(head.left);
		deepCopy.right = deepCopy(head.right);
		return head;
	}

	public static void main(String[] args) {
		int n = 3;
		solution(3);
	}
}