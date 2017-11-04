package com.Algorithms;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedUnion {
	
	
	public int[] arrayOfNodes;
	public int[] sizeArr;
	
	public WeightedUnion(int noOfNodes ){
		
		arrayOfNodes=new int[noOfNodes];
		sizeArr=new int[noOfNodes];
		
		for (int i=0;i<arrayOfNodes.length;i++){
			arrayOfNodes[i]=i;
			sizeArr[i]=0;
		}	
	}
	
	public boolean isConnected(int p, int q){
		
		return root(p)==root(q);
	}
	
	public int root(int i){

		while(i!=arrayOfNodes[i]){
			
			i=arrayOfNodes[i];
		}
		return i;
	}
	public void union(int p, int q){
		
		int p_value=root(p);
		int q_value=root(q);
		
		if(sizeArr[p_value] < sizeArr[q_value]){
			
			arrayOfNodes[p_value]=q_value;
			sizeArr[q_value]+=sizeArr[p_value];
		}
		else{
			
			arrayOfNodes[q_value]=p_value;
			sizeArr[p_value]+=sizeArr[q_value];
		}

		System.out.println(Arrays.toString(arrayOfNodes));
	}
	
	public static void main(String[] args) {

		
		int no_of_nodes=StdIn.readInt();
		System.out.println(no_of_nodes);
		WeightedUnion wuf=new WeightedUnion(no_of_nodes);
		
		while(!StdIn.isEmpty()){
			
			int p= StdIn.readInt();
			int q =StdIn.readInt();
			if(!wuf.isConnected(p, q)){
				
				wuf.union(p,q);
				StdOut.println(p +"   "+q);
			}
			else{
				
				System.out.println("Already Connected");
			}
			
		}
	
	}
}
