package algorithm30.ShortestPathProblem;

import java.util.ArrayList;

public class Timetrip {
	
	 //Setting
	static int V;
	static int MAX_V;
	static ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
	
	//reachable[u][v]: u에서 v로 가는 경로가 있는가?
	static boolean[][] reachable = new boolean[MAX_V][MAX_V];
	
	static int bellman(int src, int target){
		int[] upper = generateArray(V, Integer.MAX_VALUE);
		upper[src] = 0;
		
		//V-1번 순회
		for(int iter = 0; iter<V-1; ++iter)
			for(int here=0; here<V; ++here)
				for(int i=0;i<adj.get(here).size();i++){
					int there = adj.get(here).get(i).first;
					int cost = adj.get(here).get(i).second;
					
					upper[there] = Integer.min(upper[there], upper[here]+cost);
				}
		
		//음수 사이클의 존재 여부를 확인
		for(int here=0; here<V; ++here)
			for(int i=0; i<adj.get(here).size(); i++){
				int there = adj.get(here).get(i).first;
				int cost = adj.get(here).get(i).second;
			if(upper[here]+cost<upper[there])
				if(reachable[src][here] && reachable[here][target])
					return -Integer.MAX_VALUE;
			}
		return upper[target];		
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
