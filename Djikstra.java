package Graph;
import java.util.*;
public class Djikstra {
	
	LinkedList<Pair> adj[];
	
	public Djikstra(int v) {
		
		adj = new LinkedList[v];
		
		for(int i = 0; i<v; i++) {
			adj[i] = new LinkedList<Pair>();
		}
		
	}
	
	void addEdges(int s, int d, int w){
		adj[s].add(new Pair(d, w));
		adj[d].add(new Pair(s, w));
	}
	
	void djiktra(int src) {
		
		int len = adj.length;
		int dis[] = new int[len];
		
		for(int i = 0; i<len; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		
		dis[src] = 0;
		
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(len , new Node());
		
		queue.add(new Pair(src, 0));
		
		while(!queue.isEmpty()) {
			
			Pair node = queue.poll();
			
			for(Pair it : adj[node.getNode()]) {
				
				int d = dis[node.getNode()] + it.getWeight();
				if(d < dis[it.getNode()]) {
					dis[it.getNode()] = d;
					queue.add(it);
				}
				
			}
			
		}
		
		for(Pair p : queue) {
			System.out.print(p.getWeight()+" ");
		}						
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices: ");
		
		int v = sc.nextInt();
		Djikstra dj = new Djikstra(v);
		
		System.out.println("Enter the edges count: ");
		int e = sc.nextInt();
		
		for(int i = 0; i<e; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			
			dj.addEdges(s, d, w);
		}
		
		dj.djiktra(0);
	}

}

class Pair implements Comparator<Pair>{
	int node ;
	int w;
	Pair(int node, int w){
		this.node = node;
		this.w = w;
	}
	
	int getNode() {
		return node;
	}
	
	int getWeight() {
		return w;
	}

	@Override
	public int compare(Pair o1, Pair o2) {
		
		if(o1.w < o2.w) {
			return -1;
		}
		
		if(o1.w > o2.w) {
			return 1;
		}
		
		return 0;
	}
}