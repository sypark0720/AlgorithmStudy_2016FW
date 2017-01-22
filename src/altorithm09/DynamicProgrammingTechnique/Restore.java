package altorithm09.DynamicProgrammingTechnique;

import algorithm08.DynamicProgramming.ArrayGenerator;

public class Restore {

	static final int MAX_N=15;
	int k;
	String[] word = new String[MAX_N];
	int cache[][] = ArrayGenerator.generateInt(MAX_N, 1<<MAX_N);
	int overlap[][] = ArrayGenerator.generateInt(MAX_N, MAX_N);
	
	int restore(int last, int used){
		//기저사례
		if(used == (1<<k)-1) return 0;
		
		//메모제이션
		int ret = cache[last][used];
		if( ret!= -1) return ret;
		ret = 0;
		for(int next=0; next<k; ++next)
			if((used & (1<<next)) == 0){
				int cand = overlap[last][next]+restore(next, used+(1<<next));
				ret = Integer.max(ret, cand);
				cache[last][used] = ret;
			}
		return ret;
	}
	
	String reconstruct(int last, int used){
		//기저 사례
		if(used == (1<<k)-1) return "";
		//다음에 올 문자열 조각을 찾는다.
		for(int next = 0; next<k; ++next){
			//next가 이미 사용되었으면 제외
			if((used & (1<<next))!=0) continue;
			//next를 사용했을 경우의 답이 최적해와 같다면 next 사용
			int ifUsed = restore(next, used + (1<<next))+overlap[last][next];
			if(restore(last, used)==ifUsed)
				return (word[next].substring(overlap[last][next])+reconstruct(next, used+(1<<next)));
		}
		//뭔가 잘못된
		return "**oops**";
	}
			
			
			
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
