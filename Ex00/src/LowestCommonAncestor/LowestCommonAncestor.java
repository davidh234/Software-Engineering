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
	
} 

