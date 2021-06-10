package Graph;
import java.util.*;

public class CyclicDetection {

	//Cyclic Detection using DFS on directed Graphs
	
	ArrayList<ArrayList<Integer>> adj;
	
	CyclicDetection(int v){
		adj = new ArrayList<>(v);
		for(int i = 0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	void setDirectedEdges(int s, int d) {
		adj.get(s).add(d);
	}
	
	boolean checkCyclic() {
		int len = adj.size();
		int vis[] = new int[len];
		int dfsVis[] = new int[len];
		
		for(int i = 0; i<len ; i++) {
			if(vis[i] == 0) {
				if(dfsCheckDirectedCycle(i, vis, dfsVis)) {
					return true;
				}
			}
		}
		return false;	
	}
	
	boolean dfsCheckDirectedCycle(int node, int[] vis, int[] dfsVis) {
		
		if(vis[node] == 0) {
			vis[node] = 1;
			dfsVis[node] = 1;
		}
		
		for(int it: adj.get(node)) {
			
			if(vis[it] == 0) {
				if(dfsCheckDirectedCycle(it, vis, dfsVis)) {
					return true;
				}
			}else if(dfsVis[it] == 1){
				return true;
			}
		}
		
		dfsVis[node] = 0;
		return false;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertex: ");
		
		int v = sc.nextInt();
		CyclicDetection c = new CyclicDetection(v);
		
		System.out.println("Enter the number of edges: ");
		int n = sc.nextInt();
		
		for(int i = 0; i<n; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			c.setDirectedEdges(s, d);
		}
		System.out.println(c.checkCyclic());
		
	}

}
