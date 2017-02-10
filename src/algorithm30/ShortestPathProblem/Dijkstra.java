package algorithm30.ShortestPathProblem;

import java.util.ArrayList;

public class Dijkstra {
	
	static int v;
	static int[] dist;
	
	static ArrayList<Integer> dijkstra(int src){
		dist = generateArray(v, Integer.MAX_VALUE);
		dist[src] = 0;
		priority_queue<pair<int, int>> pq;
		pq.push(make_pair(0,src));
		
		while(!pa.empty()){
			int cost = -qp.top().first;
			int here = pq.top().second;
			pq.pop();
		}
		
		if(dist[here]<cost) continue;
		
		for(int i=0; i<adj[here].size();++i){
			int there = adj[here][i].first;
			int nextDist = cost+adj[here][i].second;
			
			if(dist[there]>nextDist){
				dist[there]=nextDist;
				pq.push(make_pair(-nextDist, there));
			}
		}
		return dist;
	}
	
	static int[] generateArray(int size, int value){
		int[] ret = new int[size];
		for(int i=0; i<size;i++){
			ret[i] = value;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
