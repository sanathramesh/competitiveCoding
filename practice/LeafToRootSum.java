import java.util.*;

class LeafToRootNode {
	int val;
	LeafToRootNode left;
	LeafToRootNode right;

	public LeafToRootNode(int val) {
		this.val = val;
	}
}

class LeafToRootSum {
	static int sum = 0;
	static void solution(LeafToRootNode n) {
		recur(n, 0);
		System.out.println(sum);
	}

	static void recur(LeafToRootNode n, int current) {

		if(n.left==null && n.right==null) {
			current = current*10 + n.val;
			sum = (sum%1003+current%1003)%1003;
			return;
		}
		if(n.left!=null) {
			recur(n.left, (current*10+n.val)%10003);
		}
		if(n.right!=null) {
			recur(n.right, (current*10+n.val)%10003);
		}
	}

	public static void main(String[] args) {
		LeafToRootNode n = new LeafToRootNode(1);
		n.left = new LeafToRootNode(2);
		n.right = new LeafToRootNode(3);
		solution(n);
	}
}