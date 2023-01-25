import java.util.*;

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class HeightOfABinaryTree {
	static int solution(Node root) {
		if(root==null) {
			return 0;
		}
		return 1 + Math.max(solution(root.left), solution(root.right));
	}


	public static void main(String[] args) {
		Node root = new Node(2);
		Node left1 = new Node(3);
		Node right1 = new Node(4);
		Node left2 = new Node(5);
		Node left3 = new Node(6);
		root.left = left1;
		root.right = right1;
		left1.left = left2;
		left2.left = left3;
		int result = solution(root);
		System.out.println(result);
	}
}