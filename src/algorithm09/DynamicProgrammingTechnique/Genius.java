package algorithm09.DynamicProgrammingTechnique;

import java.util.ArrayList;
import java.util.List;

public class Genius {
	
	static int n; //곡 수
	static int k; //문제에서, k분 30초에 좋아하는 노래가 재생되고 있을 확률을 구하라고 한다.
	static int[] length = new int[50]; //노래의 길이
	static double[][] T = new double[50][50]; //i번 노래 후, j번 노래가 재생될 확률
	
	//c[time][song]: time분 후에 song번 노래가 시작할 확률
	List<Double> getProb1(){
		double[][] c = new double[5][50];
		c[0][0] = 1.0;
		for(int time=1; time<=k; ++time)
			for(int song=0; song<n; ++song){
				double prob = c[time%5][song];
				prob=0;
				for(int last=0; last<n; ++last)
					prob+=c[(time-length[last]+5)%5][last]*T[last][song];
			}
		List<Double> ret = new ArrayList<Double>();
		double temp;
		//song번 노래가 재생되고 있을 확률
		for(int song=0; song<n; ++song)
			for(int start=k-length[song]+1; start<=k; ++start){
				temp = ret.get(song) + c[start%5][song];
				ret.set(song, temp);
			}
		return ret;		
	}
}
