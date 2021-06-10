package Graph;

import java.util.*;

public class BellmanFord {

	
	void bellmanFord( ArrayList<Nodes> edges ,int src, int N) {
		
        int dist[] = new int[N];
        for(int i = 0;i<N;i++) dist[i] = 10000000; 

        dist[src] = 0;

    	for(int i = 1;i<=N-1;i++) {
    		for(Nodes node : edges) {
    			if(dist[node.getS()] + node.getW() < dist[node.getD()]) {
    				dist[node.getD()] = dist[node.getS()] + node.getW(); 
    			}
    		}
    	}

    	int fl = 0; 
    	for(Nodes node: edges) {
    		if(dist[node.getS()] + node.getW() < dist[node.getD()]) {
    			fl = 1;
    			System.out.println("Negative Cycle"); 
    			break;
    		}
    	}

    	if(fl == 0) {
    		for(int i = 0;i<N;i++) {
    			System.out.println(i + " " + dist[i]); 
    		}
    	}
	}
	
	public static void main(String[] args) {
		
		int n = 6;
        ArrayList<Nodes> adj = new ArrayList<Nodes>();
		
			
		adj.add(new Nodes(3, 2, 6));
		adj.add(new Nodes(5, 3, 1));
		adj.add(new Nodes(0, 1, 5));
		adj.add(new Nodes(1, 5, -3));
		adj.add(new Nodes(1, 2, -2));
		adj.add(new Nodes(3, 4, -2));
		adj.add(new Nodes(2, 4, 3));

	
		BellmanFord obj = new BellmanFord(); 
		obj.bellmanFord(adj, 0, n);
		
	}
}

class Nodes{
	
	int s,d,w;
	
	public Nodes(int s, int d, int w) {
		this.s =s;
		this.d =d;
		this.w =w;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}
	
	
	
}