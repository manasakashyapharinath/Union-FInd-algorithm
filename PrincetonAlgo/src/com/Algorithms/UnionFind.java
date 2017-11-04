package com.Algorithms;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
	
	public int[] arrayOfNodes;
	
	public UnionFind(int nodes) {
		
		arrayOfNodes=new int[nodes];
		for (int i=0;i<arrayOfNodes.length;i++){
			arrayOfNodes[i]=i;
		}
	}
	public boolean isConnected(int p, int q){
	
		if(arrayOfNodes[p]==arrayOfNodes[q])
			return true;
		else
			return false;
	
	}
	public void union(int p, int q) {
		
		int p_value=arrayOfNodes[p];
		int q_value=arrayOfNodes[q];

		for(int i = 0;i<arrayOfNodes.length;i++){
			
			if(arrayOfNodes[i]==p_value){
				
				arrayOfNodes[i]=q_value;
			}
		
		}   
		System.out.println(Arrays.toString(arrayOfNodes));
	}
	
public static void main(String[] args) {
	
		int no_of_nodes=StdIn.readInt();
		System.out.println(no_of_nodes);
		UnionFind uf=new UnionFind(no_of_nodes);
		
		while(!StdIn.isEmpty()){
			
			int p= StdIn.readInt();
			int q =StdIn.readInt();
			if(!uf.isConnected(p, q)){
				
				
				uf.union(p,q);
				StdOut.println(p +"   "+q);
			}
			else{
				
				System.out.println("Already Connected");
			}
			
		}
	}

	
}
