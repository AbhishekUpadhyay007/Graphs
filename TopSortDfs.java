package Graph;
import java.util.*;
public class TopSortDfs {

	ArrayList<ArrayList<Integer>> adj;
	
	public TopSortDfs(int v) {
		
		adj = new ArrayList<>(v);
		
		for(int i = 0; i<v ; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
	}
	
	void addDirectedEdges(int s, int d) {
		adj.get(s).add(d);
	}
	
	void topoSortDfs() {
		
		int len = adj.size();
		int vis[] = new int[len];
		
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i<len; i++) {
			
			if(vis[i] == 0) {
				dfsTopo(i, st, vis);
			}
			
		}
		
		int topo[] = new int[len];
		int i = 0;
		while(!st.isEmpty()) {
			topo[i++] = st.pop();
		}
		
		System.out.println(Arrays.toString(topo));
	}
	
	void dfsTopo(int node, Stack<Integer> st , int[] vis) {
		
		vis[node] = 1;
		
		for(int it : adj.get(node)) {
			if(vis[it] == 0) {
				dfsTopo(it, st, vis);
			}
		}
		
		st.add(node);
		
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertex: ");
		int v = sc.nextInt();
		TopSortDfs  t = new TopSortDfs(v);
		
		System.out.println("Enter the number of edges: ");
		int e = sc.nextInt();
		
		
		for(int i = 0; i<e; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			t.addDirectedEdges(s, d);
		}
		
		t.topoSortDfs();
		
	}

}
