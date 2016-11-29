package algorithm08.DynamicProgramming;

import java.util.ArrayList;

public class Numb3rs {
	
	int n, d, p, q;
	
	int[][] connected = new int[51][51];
	int[] deg = new int[51];  //deg[i]:마을 i와 연결된 마을의 개수
	
	//완전탐색 알고리즘 : p에서 시작해 q까지 가는 길이 n+1인 경로들을 모두 생성
	//d: 지난 일수
	double search(ArrayList<Integer> path){
		
		//기저 사례 -> d일이 지난 경우
		if(path.size() == d+1){
			//q에서 끝나지 않으면 무효
			if(path.get(path.size()-1) != q) return 0.0;
			
			//path의 출현 확률
			double ret = 1.0;
			for(int i=0; i + 1<path.size(); ++i)
				ret /= deg[path.get(i)];
			return ret;
		}
		
		//완전탐색 :경로의 다음 위치를 결정한다.
		double ret = 0.0;
		for( int there = 0; there<n; ++there)
			if(connected[path.get(path.size()-1)][there] == 1){
				path.add(there);
				ret += search(path);
				path.remove(path.size()-1);
			}
		return ret;		
	}
	
	//동적 계획법 알고리즘
	double[][] cache = ArrayGenerator.generateDouble(51, 101);
	//days일째에 here번 마을에 숨어 있다고 가정하고, 마지막 날에 q번 마을에 숨어 있을 조건부 확률 반환.
	double search2(int here, int days){
		//기저 사례: d일이 지난 경우
		if(days == d) return (here == q? 1.0:0.0);
		
		//메모제이션
		double ret = cache[here][days];
		if(ret > -0.5) return ret;
		ret = 0.0;
		for( int there = 0; there<n; ++there){
			if(connected[here][there]==1)
				ret += search2(there, days+1)/deg[here];
		}
		cache[here][days] = ret;
		return ret;
	}
	
	//계산 순서 반대반향으로
	//here이 지금, there이 어제
	//탈옥 후 days일째에 두니발 박사가 here번 마을에 숨어 있을 확률
	double search3(int here, int days){
		if(days == d) return (here == q? 1.0:0.0);
		
		//메모제이션
		double ret = cache[here][days];
		if(ret > -0.5) return ret;
		ret = 0.0;
		
		for( int there = 0; there<n; ++there){
			if(connected[here][there]==1)
				ret += search3(there, days-1)/deg[there];
				//탈옥 후 days-1일 째에 두니발 박사가 there번 마을에 숨어 있을 확률
		}
		cache[here][days] = ret;
		return ret;
	}
	
	
	
	
	
	public static void main(String[] args){
		
	}

}
