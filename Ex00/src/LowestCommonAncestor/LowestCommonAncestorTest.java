package LowestCommonAncestor;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
	
	/*
	 * 
	 * Given two nodes that are in the DAG, ensure that they can be found if they're connected (ie. One node is a child of another)
	 * 
	 */
	@Test
	void testForExistenceOfConnectionInDAG() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(5);
		dag.addEdge(1, 2);
		dag.addEdge(2, 3);
		boolean hasPath = dag.hasPath(1,3);
		assertEquals(true, hasPath);		//path from 1->2->3
		
		dag.addEdge(1, 4);
		boolean hasPath2 = dag.hasPath(4, 3);
		assertEquals(false, hasPath2);		//no path in a DAG from 4 to 3
	}
	
	/*
	 * 
	 * This test should show that a cycle cannot be added in the DAG. 
	 * 
	 */
	@Test
	void testDAGDoesNotAllowCycles() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(5);
		dag.addEdge(1, 2);
		dag.addEdge(2, 3);
		dag.addEdge(3, 4);
		boolean cycle = dag.addEdge(4, 1); //creating a cycle should return false
		
		assertEquals(false, cycle); 
	}
	
	@Test
	void testLCAonEmptyDAG() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(0);
		ArrayList<Integer> output = dag.lowestCommonAncestor(1,2);
		
		assertTrue(output.isEmpty());
	}
	
	/*
	 * 
	 * Given a single connection where one node is a parent of another, test can the LCA algorithm correctly identify the LCA as the parent node
	 * 
	 */
	@Test
	void testLCAonSingleConnectionDAG() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(3);
		dag.addEdge(1, 2);
		
		ArrayList<Integer> output = dag.lowestCommonAncestor(1, 2);	//1 is a parent of 2 so should return 1
		
		assertTrue(output.contains(1));
	}
	
	/*
	 * 
	 * Given a valid DAG where there is multiple nodes, test if the LCA algorithm can find the correct LCA.
	 * 
	 */
	@Test
	void testLCAOnValidDAG() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(9);
		ArrayList<Integer> output;
		
		dag.addEdge(1, 2);
		dag.addEdge(2, 3);
		dag.addEdge(3, 4);
		dag.addEdge(1, 5);
		dag.addEdge(5, 6);
		
		output = dag.lowestCommonAncestor(4, 6); //LCA = 1 (root)
		assertTrue(output.contains(1));
	}
	
	/*
	 * 
	 * Test to ensure correct output when there is multiple LCA's for 2 given nodes
	 * 
	 */
	@Test
	void testLCAWhereMultipleLCAsInDAG() {
		DAGLowestCommonAncestor dag = new DAGLowestCommonAncestor(9);
		ArrayList<Integer> output;
		
		//both 1 and 5 are the LCA for 2 and 3
		dag.addEdge(1, 2);
		dag.addEdge(1, 3);
		dag.addEdge(3, 4);
		dag.addEdge(5, 2);
		dag.addEdge(5, 3);
		
		output = dag.lowestCommonAncestor(2, 3);
		
		assertTrue(output.size() == 2);
		assertTrue(output.contains(1));
		assertTrue(output.contains(5));
	}
	
	
	@Test 
	void testInputToBST() {
		BSTLowestCommonAncestor test = new BSTLowestCommonAncestor();
		Node node1 = new Node(5);
		Node node2 = new Node(6);
		Node node3 = new Node(4);
		Node node4 = new Node(3);
		test.addNode(node1);
		test.addNode(node2);
		test.addNode(node3);
		test.addNode(node4);
		
		boolean output1 = test.checkIfNodesAreInBST(5, 6);
		boolean output2 = test.checkIfNodesAreInBST(4, 3);
		
		assertTrue(output1 && output2);
	}
	
	/*
	 * Given an empty BST, we should expect a null return value (but not a runtime error) from the lca
	 * algorithm.
	 */
	@Test
	void testEmptyBST() {
		BSTLowestCommonAncestor test = new BSTLowestCommonAncestor();
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
		BSTLowestCommonAncestor test = new BSTLowestCommonAncestor();
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
		BSTLowestCommonAncestor test = new BSTLowestCommonAncestor();
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
		BSTLowestCommonAncestor test = new BSTLowestCommonAncestor();
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
