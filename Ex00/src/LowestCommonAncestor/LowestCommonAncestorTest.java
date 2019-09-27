package LowestCommonAncestor;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {
	
	@Test 
	void testInputToBST() {
		LowestCommonAncestor test = new LowestCommonAncestor();
		Node node1 = new Node(5);
		Node node2 = new Node(6);
		Node node3 = new Node(4);
		Node node4 = new Node(3);
		test.addNode(node1);
		test.addNode(node2);
		test.addNode(node3);
		test.addNode(node4);
	}
	
	/*
	 * Given an empty BST, we should expect a null return value (but not a runtime error) from the lca
	 * algorithm.
	 */
	@Test
	void testEmptyBST() {
		LowestCommonAncestor test = new LowestCommonAncestor();
		Node output = test.lca(null, 0, 0);
		assertEquals(null, output);
		Node output2 = test.lca(null, 3, -1);
		assertEquals(null, output2);
	}
	
	/*
	 * Testing the LCA for a single node BST. should return null as there is no common node between some node N and null
	 * 
	 */
	@Test
	void TestSingleItemBST() {
		LowestCommonAncestor test = new LowestCommonAncestor();
		test.addNode(new Node(5));
		Node output = test.lca(test.head, 5, 8);
		assertEquals(null, output);
	}
	
	/*
	 * 
	 * Testing to see if LCA returns null nodes if one or both are not present in the tree.
	 */
	@Test
	void TestMissingItemsInBST() {
		LowestCommonAncestor test = new LowestCommonAncestor();
		test.addNode(new Node(5));
		test.addNode(new Node(6));
		test.addNode(new Node(4));
		test.addNode(new Node(3));
		
		Node output = test.lca(test.head, 5, 8); //8 not present
		assertEquals(null, output);
		
		Node output2 = test.lca(test.head, 9, 10); //both 9 and 10 not present
		assertEquals(null, output2);
	}
	
	@Test
	void TestSingleMissingItemInBST() {
		fail("Not yet implemented");
	}
	
	@Test
	void TestValidBST() {
		fail("Not yet implemented");
	}
}
