package com.Algorithms;

import java.util.Arrays;

import javax.swing.plaf.synth.SynthSpinnerUI;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionFind {

	
	public int[] arrayOfNodes;
	
	public QuickUnionFind(int nodes){
		
		arrayOfNodes=new int[nodes];
		for (int i=0;i<arrayOfNodes.length;i++){
			arrayOfNodes[i]=i;
		}
	}
	
	public int root(int i){
		
		while(i!=arrayOfNodes[i]){
			
			i=arrayOfNodes[i];
		}
		
		return i;
	}
	
	public boolean isConnected(int p, int q){
		
		return root(p)==root(q);
	}
	
	public void union(int p, int q){
		
		int p_value=root(p);
		int q_value=root(q);
		
		arrayOfNodes[p_value]=q_value;	
		
		System.out.println(Arrays.toString(arrayOfNodes));
	}
	
	public static void main(String[] args) {

		int no_of_nodes=StdIn.readInt();
		System.out.println(no_of_nodes);
		QuickUnionFind quf=new QuickUnionFind(no_of_nodes);
		
		while(!StdIn.isEmpty()){
			
			int p= StdIn.readInt();
			int q =StdIn.readInt();
			if(!quf.isConnected(p, q)){
					
				quf.union(p,q);
				StdOut.println(p +"   "+q);
			}
			else{
				
				System.out.println("Already Connected");
			}
			
		}
	
	}
}
