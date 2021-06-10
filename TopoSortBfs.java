package Graph;
import java.util.*;
public class TopoSortBfs {
	
	static LinkedList<Integer>[] adj;
	
	public TopoSortBfs(int v) {
		adj = new LinkedList[v];
		
		for(int i = 0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	void addDirectedEdges(int s, int d) {
		adj[s].add(d);
	}
	
	void topoSort() {
		
		int n = adj.length;
		int indegree[] = new int[n];
		int[] topo = new int[n];
		
		for(int i = 0; i <n ; i++) {
			for(int it : adj[i]) {
				indegree[it]++;
			}
		}
		System.out.println("Indegree: "+Arrays.toString(indegree));
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0; i<n; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		int i = 0;
		while(!q.isEmpty()) {
			
			int node = q.poll();
			topo[i++] = node;
			
			for(int it : adj[node]) {
				indegree[it]--;
				if(indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		
		System.out.println(Arrays.toString(topo));
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertexs: ");
		int v = sc.nextInt();
		
		TopoSortBfs t = new TopoSortBfs(v);
		
		System.out.println("Enter the number of edges:");
		int e = sc.nextInt();
		
		for(int i = 0; i<e; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			t.addDirectedEdges(s, d);
		}

		t.topoSort();
	}

}
