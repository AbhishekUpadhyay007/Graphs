package Graph;

import java.util.*;

public class KosarajuAlgo {

	static ArrayList<ArrayList<Integer>> adj;
	
	void dfs(int node, Stack<Integer> st, int[] vis) {
		
		vis[node] = 1;
		for(Integer it : adj.get(node)) {
			if(vis[it] != 1) {
				dfs(it, st, vis);
			}
		}
		st.push(node);	
	}
	
	void revDfs(ArrayList<ArrayList<Integer>> transform, int[] vis, int node) {
		vis[node] = 1;
		System.out.print(node + " "); 
		for(int it : transform.get(node)) {
			if(vis[it] == 0) {
				revDfs(transform, vis, it);
			}
		}
	}
	
	void toposort() {
		
		int n = adj.size();
		int vis[] = new int[n]; 
        Stack<Integer> st = new Stack<Integer>(); 
        for(int i = 0;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, st,  vis); 
        	}
        }

        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			transpose.add(new ArrayList<Integer>());

		for(int i = 0;i<n;i++) {
			vis[i] = 0; 
			for(Integer it: adj.get(i)) {
				transpose.get(it).add(i); 
			}
		}
		
		System.out.println(transpose);

		while(!st.isEmpty()) {
			int node = st.peek(); 
			st.pop(); 
			if(vis[node] == 0) {
				System.out.print("SCC: "); 
				revDfs(transpose,vis, node);
				System.out.println(); 
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number of nodes:");
		int n = sc.nextInt();
		
		adj = new ArrayList<>(n);
		
		for(int i = 0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
				
		System.out.println("Enter the paths:");
		int p = sc.nextInt();
		
		for(int i = 0; i<p; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			adj.get(s).add(d);
		}
		
		KosarajuAlgo k = new KosarajuAlgo();
		k.toposort();
		
	}

}
