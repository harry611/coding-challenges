class Node {
	public String data;
	public Node left = null, right = null;

	Node(String data) {
		this.data = data;
	}

	Node() {
	}

	Node(String val, Node left, Node right) {
		this.data = val;
		this.left = left;
		this.right = right;
	}

	public void print() {
		print("", this, false);
	}

	public void print(String prefix, Node n, boolean isLeft) {
		if (n != null) {
			System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
			print(prefix + (isLeft ? "|   " : "    "), n.left, true);
			print(prefix + (isLeft ? "|   " : "    "), n.right, false);
		}
	}
}
