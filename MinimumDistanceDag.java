package Graph;
import java.util.*;

public class MinimumDistanceDag {
	
	ArrayList<ArrayList<Pair>> adj;
	
	public MinimumDistanceDag(int v) {

		adj = new ArrayList<>();
		
		for(int i = 0; i<v;i++) {
			adj.add(new ArrayList<Pair>());
		}
			
	}
	
	void addDirectedEdges(int s, int d, int w) {
		adj.get(s).add(new Pair(d,w));
	}
	
	void TopoSortDfs(int src) {
		
		int len = adj.size();
		boolean vis[] = new boolean[len];
		
		
		Stack<Integer> st = new Stack<>();
		
		for(int i= 0; i<adj.size(); i++) {
			if(!vis[i]) {
				dfsTopo(i, vis, st);
			}
		}
		
		int dis[] = new int[adj.size()];
		
		for(int i = 0; i<len ; i++) {
			dis[i] = Integer.MAX_VALUE;	
		}
		
		dis[src] = 0;
		while(!st.isEmpty()) {
			int node = st.pop();
			if(dis[src] != Integer.MAX_VALUE) {
				
				for(Pair it : adj.get(node)) {
					
					int distance = dis[node] + it.getWeight();
					if(dis[it.getNode()] > distance) {
						dis[it.getNode()] = distance;
					}
				}
				
			}			
		}
		
		System.out.println(Arrays.toString(dis));
		
	}

	private void dfsTopo(int n, boolean[] vis, Stack<Integer> st) {
		
		vis[n] = true;
		for(Pair ob : adj.get(n)) {
			if(!vis[ob.getNode()]) {
				dfsTopo(ob.node, vis, st);
			}
		}
		st.push(n);
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of edges: ");
		int v = sc.nextInt();
		
		MinimumDistanceDag m = new MinimumDistanceDag(v);
		
		System.out.println("Enter the edges");
		int e = sc.nextInt();
		
		for(int i = 0; i<e; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			int w = sc.nextInt();
			
			m.addDirectedEdges(s, d, w);
		}
		
		m.TopoSortDfs(0);

	}

}

//class Pair{
//	int node ;
//	int w;
//	Pair(int node, int w){
//		this.node = node;
//		this.w = w;
//	}
//	
//	int getNode() {
//		return node;
//	}
//	
//	int getWeight() {
//		return w;
//	}
//}
