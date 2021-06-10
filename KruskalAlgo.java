package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalAlgo {

	static ArrayList<Ds> adj;
	
	public KruskalAlgo(int v) {
		adj = new ArrayList<>(v);
	}
	
	void makeSet(int parent[], int rank[]){
		for(int i = 0; i<7; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	int findParent(int node, int parent[]) {
		
		if(parent[node] == node) {
			return parent[node];
		}
		
		return parent[node] = findParent(parent[node], parent);
		
	}
	
	void union(int u , int v, int parent[], int rank[]) {
		
		u = findParent(u, parent);
		v = findParent(v, parent);
		
		if(rank[u] < rank[v]) {
			parent[u] = v;
		}else if(rank[v] < rank[u]) {
			parent[v] = u;
		}else {
			parent[u] = v;
			rank[u]++;
		}
		
	}
	
	void krusKal(int n) {
		
		Collections.sort(adj, new SortNode());
		
		int rank[] = new int[n];
		int parent[] =  new int[n];
		
		for(int i = 0; i<n; i++) {
			rank[i] = 0;
			parent[i] = i;
		}
		
		ArrayList <Ds> mst = new ArrayList<Ds>();
		int cost = 0;
		
		for(Ds node : adj) {
			
			if(findParent(node.getU(), parent) != findParent(node.getV(), parent)) {
				
				union(node.getU(), node.getV(), parent, rank);
				mst.add(node);
				cost += node.getW();
			}
			
		}
		
		System.out.println("MST cost: "+cost);
		
		for(Ds m : mst) {
			System.out.println(m.getU() +" "+ m.getV());
		}
		
	}
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		KruskalAlgo k = new KruskalAlgo(n);
		
		int p = sc.nextInt();
		
		while(p>0) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			adj.add(new Ds(s,d,w));
			
			p--;
		}
		
		k.krusKal(n);
	
	}

}

class SortNode implements Comparator<Ds>{
	@Override
	public int compare(Ds o1, Ds o2) {
		if(o1.getW() < o2.getW()) {
			return -1;
		}
		if(o1.getW() > o2.getW()){
			return 1;
		}
		return 0;
	}
}

class Ds {
	int u;
	int v;
	int w;
	
	Ds(int u, int v, int w){
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public int getU() {
		return u;
	}
	
	public int getV() {
		return v;
	}
	public int getW() {
		return w;
	}
}
