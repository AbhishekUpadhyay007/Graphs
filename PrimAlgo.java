package Graph;
import java.util.*;

public class PrimAlgo {
	
	ArrayList<ArrayList<Node>> adj;
	
	public PrimAlgo(int v) {
		
		adj = new ArrayList<>(v);
		
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<Node>());
		}
		
	}
	
	void addEdges(int s, int d, int w){
		
		adj.get(s).add(new Node(d,w));
		adj.get(d).add(new Node(s,w));
		
	}
	
	void primAlgo() {
		
		int len = adj.size();
		
		boolean mst[] = new boolean[len];
		int parent[] = new int[len];
		int key[] = new int[len];
		
		for(int i = 0; i<len; i++) {
			parent[i] = -1;
			key[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(len, new Node());
		key[0] = 0;
		pq.add(new Node(0,0));
		
		for(int i = 0; i<len-1; i++) {
			
			int u = pq.poll().getV();
			mst[u] = true;
			
			for(Node it : adj.get(u)) {
				
				if(mst[it.getV()] == false && it.getWeight() < key[it.getV()]) {
					parent[it.getV()] = u;
					key[it.getV()] = it.getWeight();
					
					pq.add(new Node(it.getV(), key[it.getV()]));
				}
				
			}
			
		}
		
		for(int i = 1; i<len; i++) {
			System.out.println(parent[i] +" "+ i);
			
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertex: ");
        int v = sc.nextInt();
        
        PrimAlgo pm = new PrimAlgo(v);
		
		System.out.println("Enter the number of edges:");
		int e = sc.nextInt();
		
		for(int i = 0; i<e; i++) {
			
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			
			pm.addEdges(s, d, w);
		}
		
		pm.primAlgo();
		

	}

}
