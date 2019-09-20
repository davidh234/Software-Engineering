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
	

	@Test
	void testEmptyBST() {
		fail("Not yet implemented");
	}
	
	@Test
	void TestSingleItemBST() {
		fail("Not yet implemented");
	}
	
	@Test
	void TestMissingItemsInBST() {
		fail("Not yet implemented");
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
