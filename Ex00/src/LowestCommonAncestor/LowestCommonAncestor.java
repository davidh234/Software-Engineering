package LowestCommonAncestor;

//A binary tree node 
class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class LowestCommonAncestor 
{ 
	Node head;
	
	public void addNode(Node node) {
		if(head == null) {
			head = node;
		}
		else {
			addNodeRecursive(head, node);
		}
	}
	
	public void addNodeRecursive(Node current, Node input) {
		if(current == null) {
			current = input;
		}
		else {
			if(input.data <= current.data) {
				if(current.left == null) {
					current.left = input;
				}
				else {
					addNodeRecursive(current.left, input);
				}
			} 
			else if(input.data > current.data) {
				if(current.right == null) {
					current.right = input;
				}
				else {
					addNodeRecursive(current.right, input);
				}
			}
		}
	}
	
	public Node lca(Node node, int n1, int n2) {
		if (node == null) 
			return null; 

		if(!checkIfNodesAreInBST(n1, n2)) {
			return null;
		}
		// If both n1 and n2 are smaller than root, then LCA lies in left 
		if (node.data > n1 && node.data > n2) 
			return lca(node.left, n1, n2); 

		// If both n1 and n2 are greater than root, then LCA lies in right 
		if (node.data < n1 && node.data < n2) 
			return lca(node.right, n1, n2); 

		return node; 
	}
	
	public boolean checkIfNodesAreInBST(int n1, int n2) {
		if(head == null) {
			return false;
		}
		boolean present = true;
		if(head.data != n1) {
			present = checkIfNodesAreInBSTRecursive(head, n1);
		}
		if(head.data != n2 && present) {
			present = checkIfNodesAreInBSTRecursive(head, n2);
		}
		return present;
	}
	
	public boolean checkIfNodesAreInBSTRecursive(Node current, int value) {
		if(current == null) {
			return false;
		}
		if(current.data > value) {
			checkIfNodesAreInBSTRecursive(current.left, value);
		}
		if(current.data < value) {
			checkIfNodesAreInBSTRecursive(current.right, value);
		}
		if(current.data == value) {
			return true;
		}
		return false;
	}
	
} 

