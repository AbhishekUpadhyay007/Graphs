package Graph;
import java.util.*;

class Node implements Comparator<Node>
{
    private int v;
    private int weight;
    
    Node(int _v, int _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
    
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}


public class test {
	void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int N)
    {
        int dist[] = new int[N];
        
        for(int i = 0;i<N;i++) dist[i] = 100000000;
        dist[s] = 0; 
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        pq.add(new Node(s, 0));
        
        while(pq.size() > 0) {
            Node node = pq.poll();
            
            for(Node it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight(); 
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
        
        for (int i = 0; i < N; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();
		
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertex: ");
        int v = sc.nextInt();
        
		for (int i = 0; i < v; i++) 
			adj.add(new ArrayList<Node>());
		
		System.out.println("Enter the number of edges:");
		int e = sc.nextInt();
		
		for(int i = 0; i<e; i++) {
			
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			
			adj.get(s).add(new Node(d,w));
			adj.get(d).add(new Node(s,w));
		}
			
		test obj = new test(); 
		obj.shortestPath(0, adj, n); 
		
    }
}
