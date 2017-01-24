package algorithm28.DepthFirstSearch;

import java.util.ArrayList;

public class DFS {
	//그래프의 인접 리스트
	private ArrayList<ArrayList<Integer>> adj;
	private boolean[] visited;
	
	public DFS(ArrayList<ArrayList<Integer>> adj) {
		super();
		this.adj = adj;
		this.visited = new boolean[adj.size()];
		
	}
	
	private void dfs(int here){
		System.out.println("DFS visits: "+here);
		visited[here] = true;
		//모든 인접 정점 순회
		for(int i=0; i<adj.get(here).size(); ++i){
			int there = adj.get(here).get(i);
			if(!visited[there])
				dfs(there);
		}
		//재귀호출 종료
	}
	
	public void dfsAll(){
		for(int i=0; i<adj.size(); ++i)
			if(!visited[i]) 
				dfs(i);
	}
	
}
