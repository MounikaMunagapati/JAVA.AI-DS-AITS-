class Node {
    int key;
    Node left, right;
    public Node(int item) {
        key = item;
        left = right = null;
    }
}
class BinaryTree {
    Node root;
    // Inorder traversal (Left, Root, Right)
    void InorderTraverseTree(Node node) {
        if (node != null) {
            InorderTraverseTree(node.left);
            System.out.print(" " + node.key);
            InorderTraverseTree(node.right);
        }
    }
	// Preorder traversal (root ,left, right)
	void PreorderTraverseTree(Node node) {
		if(node!=null){
			System.out.print(" "+node.key);
			PreorderTraverseTree(node.left);
			PreorderTraverseTree(node.right);
		}
	}
	//Postorder traversal(left,right,root)
	void PostorderTraverseTree(Node node) {
        if (node != null) {
			PostorderTraverseTree(node.left);
			PostorderTraverseTree(node.right);
			System.out.print(" "+node.key);
		}
	}
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        System.out.print("Binary Tree (Inorder):");
        tree.InorderTraverseTree(tree.root);
		System.out.print("\nBinary Tree (Preorder):");
        tree.PreorderTraverseTree(tree.root);
		System.out.print("\nBinary Tree (Postorder):");
        tree.PostorderTraverseTree(tree.root);
    }
}


