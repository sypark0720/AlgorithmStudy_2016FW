package algorithm30.ShortestPathProblem;

import java.util.ArrayList;

public class Floyd {
	
	int V;
	int MAX_V;
	int[][] adj = new int[MAX_V][MAX_V];
	int[][][] C = new int[MAX_V][MAX_V][MAX_V];
	int[][] via = new int[MAX_V][MAX_V];
	
	void allPairShortestPath1(){
		//C[0] 초기화
		for(int i=0; i<V; ++i)
			for(int j=0; j<V; ++j)
				if(i != j)
					C[0][i][j] = Integer.min(adj[i][j], adj[i][0]+adj[0][j]);
				else
					C[0][i][j] = 0;
		
		//C[k-1]이 있으면 C[k]를 계산할 수 있다.
		for(int k=1; k<V; ++k)
			for(int i=0; i<V; ++i)
				for(int j=0; j<V; ++j)
					C[k][i][j] = Integer.min(C[k-1][i][j], C[k-1][i][k]+C[k-1][k][j]);
	}
	
	
	//reduce memory usage
	void floyd(){
		for(int i=0; i<V; ++i) adj[i][i] = 0;
		for(int k=0; k<V; ++k)
			for(int i=0; i<V; ++i)
				for(int j=0; j<V; ++j)
					adj[i][j] = Integer.min(adj[i][j], adj[i][k]+adj[k][j]);
	}
	
	//실제 경로 계산
	void floyd2(){
		for(int i=0; i<V; ++i) adj[i][i] = 0;
	
		for(int k=0; k<V; ++k)
			for(int i=0; i<V; ++i)
				for(int j=0; j<V; ++j)
					if(adj[i][j] > adj[i][k]+adj[k][j]){
						via[i][j] = k;
						adj[i][j] = adj[i][k]+adj[k][j];
					}
	}
	
	void reconstruct(int u, int v, ArrayList<Integer> path){
		if(via[u][v]==-1){
			path.add(u);
			if(u!=v) path.add(v);
		}else{
			int w = via[u][v];
			reconstruct(u,w,path);
			path.remove(path.size()); //remove duplicated 'w'
			reconstruct(w,v,path);
		}
	}
}
