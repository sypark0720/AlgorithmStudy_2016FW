package algorithm30.ShortestPathProblem;

import java.util.ArrayList;

public class Druken_Floyd {
	
	int V;
	int MAX_V = 500;
	int[][] adj = new int[MAX_V][MAX_V];
	int[] delay = new int[MAX_V];
	
	int[][] W = new int[MAX_V][MAX_V]; //전체 시간 저장
	
	
	//reduce memory usage
	void solve(){
		//시간별로 정점 정렬
		int[][] order = new int[2][V];
		//order[1,i] 에는 delay[i], order[2,i]에는 i가 들어가 있다고 하자.
		
		//정점을 하나도 거치지 않고 얻을 수 있는 최단 경로
		for(int i=0; i<V; ++i)
			for(int j=0; j<V; ++j)
				if(i==j) W[i][j] = 0;
				else W[i][j] = adj[i][j];
		
		int ret = Integer.MAX_VALUE;
		for(int k=0; k<V; ++k){
			int w = order[2][k]; 
			
			for(int i=0; i<V; ++i)
				for(int j=0; j<V; ++j){
					adj[i][j] = Integer.min(adj[i][j], adj[i][k]+adj[k][j]); //E만 고려했을 때 최단 거리 저장
					W[i][j] = Integer.min(adj[i][w]+delay[w]+adj[w][j], W[i][j]); //w를 거칠 때인가, 아니면 안 거칠 때인가. 두 개중 min 경로 저장
					//단속시간이 제일 적게 걸리는 것부터 시작했으니 마지막엔 결국 '최악의 경우'가 나오게 된다
				}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
