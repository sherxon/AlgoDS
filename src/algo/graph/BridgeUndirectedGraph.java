package algo.graph;

import java.io.*;
import java.util.*;

/*
Bridges in an undirected graph:
An edge in an undirected connected graph is a bridge iff removing it disconnects the graph.

Time Complexity of below solution: O(V+E) 

Examples: wired computer network, an articulation point indicates the critical computers and a bridge indicates the critical wires or connections.

Java version this problem was tested on: java version "1.8.0_51"

Sample way of running this problem:
1): Enter the maximum number of vertices in the graph
7
Enter an edge or type quit to exit
0
1
Enter an edge or type quit to exit
0
2
Enter an edge or type quit to exit
1
2
Enter an edge or type quit to exit
1
6
Enter an edge or type quit to exit
1
3
Enter an edge or type quit to exit
1
4
Enter an edge or type quit to exit
3
5
Enter an edge or type quit to exit
4
5
Enter an edge or type quit to exit
quit
Finding Bridges
1  6
*/

class Node{
	int data;
	public Node(int data)
	{
		this.data = data;
	}
}

public class BridgeUndirectedGraph{
	LinkedList<Node> ld[];
	int temp;
	
	public BridgeUndirectedGraph(int v)
	{
		ld = new LinkedList[v];
		
		for(int i=0;i<v;i++)
		{
			ld[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(int a,int b)
	{
		ld[a].add(new Node(b));
		ld[b].add(new Node(a));
	}
	
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the maximum number of vertices in the graph");
		int V = Integer.parseInt(br.readLine());
		BridgeUndirectedGraph obj = new BridgeUndirectedGraph(V);
		
		System.out.println("Enter an edge or type quit to exit");
		String str = br.readLine();
		
		while(!str.equalsIgnoreCase("quit")){
			
			int b = Integer.parseInt(br.readLine());
			
			obj.addEdge(Integer.parseInt(str),b);
			System.out.println("Enter an edge or type quit to exit");
			str = br.readLine();
		}
		
		
		System.out.println("Bridges found: ");
		obj.findBridges(V);
	}
	
	public void findBridges(int vertices)
	{
		boolean visited[] = new boolean[vertices];
		int parent[] = new int[vertices];
		int low[] = new int[vertices];
		int disc[] = new int[vertices];
		
		for(int i=0;i<vertices;i++)
		{
			if(visited[i] != true)
			{
				bridgeUtil(i,visited,parent,low,disc);
			}
		}
	}
	
	public int min(int a,int b)
	{
		return (a<b)?a:b;
	}
	
	public void bridgeUtil(int u,boolean visited[],int parent[],int low[],int disc[])
	{
		low[u] = disc[u] = ++temp;
		visited[u] = true;
		
		LinkedList<Node> l = ld[u];
		Iterator<Node> itr = l.iterator();
		while(itr.hasNext())
		{
			int v = itr.next().data;
			
			if(visited[v] != true)
			{
				parent[v] = u;
				bridgeUtil(v,visited,parent,low,disc);
				
				// Check if the subtree rooted with v has a
        // connection to one of the ancestors of u
				low[u] = min(low[u], low[v]);
				
				// If the lowest vertex reachable from subtree
        // under v is below u in DFS tree, then u-v is
        // a bridge
				if(low[v] > disc[u])
					System.out.println(u + "  " + v);
				
				
			}else if(parent[u] != v) // Update low value of u for parent function calls.
			{
				low[u] = min(low[u],disc[v]);
			}
		}
	}
}
