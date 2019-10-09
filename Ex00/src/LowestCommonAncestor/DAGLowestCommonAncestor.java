package LowestCommonAncestor;

import java.util.ArrayList;

public class DAGLowestCommonAncestor {
	
	public static int V; //number of vertices
	
	public ArrayList<Integer>[] adj; //adjacency list representation
	
	// For LCA
		private final ArrayList<Integer>[] reverseAdj;


	public DAGLowestCommonAncestor(int V)
	{
		this.V = V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		
		// For LCA
		reverseAdj = (ArrayList<Integer>[]) new ArrayList[V];
		
		for (int v = 0; v < V; v++)
		{
			adj[v] = new ArrayList<Integer>();
			
		
			//For LCA
			reverseAdj[v] = new ArrayList<Integer>();
		}
	}

	public boolean addEdge(int v, int w)
	{
		if(v >= this.V || w >= this.V || v < 0 || w < 0){
			return false;
		}

		if(v != w && !adj[v].contains(w)){
			adj[v].add(w);
			reverseAdj[w].add(v);
			return true;
		}	
		else{
			return false;
		}
	}
	public void removeEdge(int v1, int v2) {
		//need to remove v2 to the array list at v1, and vice versa
	}
	
}
