import java.util.*;

class Node {
	int value;
	Node left;
	Node right;
	public Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}

class DiameterOfTree {
	static int maxPath = 0;
	static void solution(Node head) {
		recur(head);
	}
	static int recur(Node head) {
		if(head==null) {
			return 0;
		}
		int left = recur(head.left);
		int right = recur(head.right);
		if(left+right+1>maxPath) {
			maxPath = left+right+1;
		}
		return 1+Math.max(left, right);
	}

	public static void main(String[] args) {
		Node head = new Node(0);
		head.left = new Node(0);
		head.right= new Node(0);
		head.left.left = new Node(0);
		head.left.left.left = new Node(0);
		head.left.right = new Node(0);
		head.left.right.right = new Node(0);
		
		solution(head);
		System.out.println(maxPath);
	}
}