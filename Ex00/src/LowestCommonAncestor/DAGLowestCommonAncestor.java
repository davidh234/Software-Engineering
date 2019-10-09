package LowestCommonAncestor;

import java.util.ArrayList;

public class DAGLowestCommonAncestor {
	
	public static int V; //number of vertices
	
	public ArrayList<Integer>[] adj; //adjacency list representation
	
	public DAGLowestCommonAncestor(int v) {
		this.V = v;
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for(int i =0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
}
