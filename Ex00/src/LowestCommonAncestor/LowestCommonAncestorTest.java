package LowestCommonAncestor;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {
	/*
	 * 
	 * Testing that the DAG constructor correctly assigns values and initialises the DAG correctly
	 * 
	 */
	@Test
	void testDAGConstructor() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(5);
		assertEquals(dag.adj.length, 5); 		//confirm that DAG is correctly allocating the right number of arraylists
		assertEquals(dag.V, 5); 				//confirm DAG class is correctly assigning the number of vertices
		assertTrue(dag.adj[0].isEmpty()); 		//confirm DAG is creating empty lists for each index, and not null.
	}
	
	/*
	 * 
	 * Check that an edge is added correctly. Because this is an adjacency list implementation of DAG this is the only important insert
	 * 
	 */
	@Test
	void testAddEdgeToDAG() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(5);
		dag.addEdge(1,2);
		assertEquals(2, dag.adj[1].get(0));
	}
	
	/*
	 * 
	 * Tests to check that invalid cases for adding an edge are caught and properly handled
	 * 
	 */
	@Test
	void testAddInvalidEdgeToDAG() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(0);
		boolean output = dag.addEdge(1,2);
		assertEquals(false, output);	//fails at first conditional branch due to empty DAG - no vertices created
		
		DAGLowestCommonAncestor dag1 = new DAGLowestCommonAncestor(1);
		boolean output1 = dag1.addEdge(1, 2);
		assertEquals(false, output1);	//fails at first conditional branch - values are larger than V
		
		DAGLowestCommonAncestor dag2 = new DAGLowestCommonAncestor(3);
		boolean output2 = dag2.addEdge(1, 1);
		assertEquals(false, output2);	//fails - values are equal (trying to add an edge to itself)
		
		DAGLowestCommonAncestor dag3 = new DAGLowestCommonAncestor(6);
		dag3.addEdge(1, 2);
		boolean output3 = dag3.addEdge(1, 2);
		assertEquals(false, output3);	//fails due to edge already existing
	}
	
	
	@Test
	void testForExistenceOfConnectionInDAG() {
		
	}
	
	@Test
	void testDAGDoesNotAllowCycles() {
		
	}
	
	@Test
	void testLCAonEmptyDAG() {
		
	}
	
	@Test
	void testLCAonSingleConnectionDAG() {
		
	}
	
	@Test
	void testLCAOnValidDAG() {
		
	}
	
	
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
	
	/*
	 * 
	 * Test to see if given a valid BST, the LCA algorithm returns the correct Lowest common ancestor (LCA).
	 * 
	 */
	@Test
	void TestValidBST() {
		LowestCommonAncestor test = new LowestCommonAncestor();
		test.addNode(new Node(5));
		test.addNode(new Node(6));
		test.addNode(new Node(4));
		test.addNode(new Node(3));
		test.addNode(new Node(7));
		test.addNode(new Node(8));
		
		Node output = test.lca(test.head, 3, 4); //should be 4
		assertEquals(4, output.data);
		
		Node output2 = test.lca(test.head, 3, 6); // should be 5
		assertEquals(5, output2.data);
		
		Node output3 = test.lca(test.head, 6, 8);
		assertEquals(6, output3.data);
	}
}
