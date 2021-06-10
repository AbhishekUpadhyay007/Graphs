package Graph;
import java.util.*;
public class MinimumDistance {
	
	ArrayList<ArrayList<Integer>> adj;
	
	public MinimumDistance(int v) {
		// TODO Auto-generated constructor stub
		adj = new ArrayList<>(v);
		
		for(int i = 0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	void addEdges(int s, int d) {
		adj.get(s).add(d);
		adj.get(d).add(s);
	}
	
	void minimumDistance(int src) {
		
		int len = adj.size();
		int [] dis = new int[len];
		
		for(int i = 0; i<len; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		
		dis[src] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while(!q.isEmpty()) {
		
			int node = q.poll();
			int d = dis[node] + 1;
			
			for(int it : adj.get(node)) {
				
				if(d < dis[it]) {
					dis[it] = d;
					q.add(it);
				}
				
			}
			
		}		
		
		for(int i = 0; i<len; i++) {
			System.out.println(src+"-->"+i+" "+ dis[i]);
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertexs: ");
		int v = sc.nextInt();
		
		MinimumDistance m = new MinimumDistance(v);
		
		System.out.println("Enter the number of edges:");
		int e = sc.nextInt();
		
		for(int i = 0; i<e; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			
			m.addEdges(s, d);
		}

		m.minimumDistance(1);

	}

}
