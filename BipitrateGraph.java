package Graph;

import java.util.*;

public class BipitrateGraph {
	
	LinkedList<Integer> adj[];

	public BipitrateGraph(int v) {
		
		adj =  new LinkedList[v];
		for(int i = 0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	void addEdges(int s, int d) {
		adj[s].add(d);
		adj[d].add(s);
	}
	
	void bfsPrint(int node) {
		
		boolean vis[] = new boolean[adj.length];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(node);
		vis[node] = true;
		System.out.print(node +" ");
		while(!q.isEmpty()) {
			
			int n = q.poll();
	
			for(Integer it : adj[n]) {
				if(!vis[it]) {
					q.add(it);
					vis[it] = true;
					System.out.print(it+" ");
				}
			}
			
		}
	}
	
	boolean checkBipartite(int len) {
		
		int color[] = new int[len];
		
		for(int i = 0; i<len; i++) {
			color[i] = -1;
		}
		
		for(int i = 0; i< len; i++) {
			if(color[i] == -1) {
				if(dfsBipartiate(adj, i, color)) return true;
			}
		}
		
		return false;
	}
	
	boolean dfsBipartiate(LinkedList<Integer>[] adj , int node, int color[]) {
		
		if(color[node] == -1) {
			color[node] = 1;
		}
		
		for(int it : adj[node]) {
			
			if(color[it] == -1) {
				color[it] = 1 - color[node];
				if(dfsBipartiate(adj, it, color)) {
					return true;
				}
			}else if(color[it] == color[node]) {
				return false;
			}
			
		}
		
		return false;
	}
	
	boolean bfsBipartitate(LinkedList<Integer>[] adj , int node, int[] color) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(node);
		color[node] = 1;
		
		while(!q.isEmpty()) {
			
			int n = q.poll();
			
			for(int it : adj[n]) {
				if(color[it] == -1) {
					q.add(it);
					color[it] = 1 - color[n];
				}else if(color[it] == color[n]) {
					return false;
				}
			}
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Vertices:");
		int n = sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e = sc.nextInt();
		
		BipitrateGraph b = new BipitrateGraph(n);
		
		for(int i = 0; i<e; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			b.addEdges(s, d);						
		}
		
		System.out.println("BFS print: ");
		b.bfsPrint(0);
		
		System.out.println("Is Bipartiate: "+b.checkBipartite(n));
		
		
	}
}
