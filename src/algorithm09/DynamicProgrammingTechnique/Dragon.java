package algorithm09.DynamicProgrammingTechnique;

public class Dragon {

	//초기 문자열 seed를 generations 세대 진화시킨 결과 출력
//	void curve(String seed, int generations){
//		//기저사례
//		if(generations == 0){
//			cout << seed;
//			return;
//		}
//		
//		for(int i=0; i< seed.length(); ++i){
//			if(seed.charAt(i) == 'X') curve("X+YF", generations-1);
//			else if(seed.charAt(i) == 'Y') curve("FX-Y", generations-1);
//			else cout << seed.charAt(i);
//			
//		}
//	}
	
	static final int MAX = 1000000000+1;
	static int[] length = new int[51]; //X나 Y를 i번 치환한 후의 길이
	
	//precalc: X나 Y를 i번 치환한 후의 길이가 MAX보다 큰 경우 length에 MAX만 저장. 
	static void precalc(){
		length[0] =1;
		for(int i=1; i<=50;++i)
			length[i] = Integer.min(MAX, length[i-1]*2+2);
	}
	
	static final String EXPAND_X = "X+YF";
	static final String EXPAND_y = "FX-Y";
	
	//dragonCurve를 generations 진화시킨 결과에서 skip번째 문자를 반환한다.
	static char expand(String dragonCurve, int generations, int skip){
		//base case
		if(generations == 0){
			assert(skip < dragonCurve.length());
			return dragonCurve.charAt(skip);
		}
		
		for(int i=0; i<dragonCurve.length(); ++i)
			//문자열이 확장되는 경우
			if(dragonCurve.charAt(i)=='X' || dragonCurve.charAt(i)=='Y'){
				if(skip >= length[generations]) skip -= length[generations];
				else if(dragonCurve.charAt(i) == 'X') return expand(EXPAND_X, generations-1, skip);
				else return expand(EXPAND_y, generations-1, skip);
			}
		
		//확장되진 않지만 건너뛰어야 할 경우
		else if(skip>0) --skip;
		//답을 찾은 경우
		else return dragonCurve.charAt(i);
		
		return '#'; //이 줄은 수행되지 않음
	}
	
	
	public static void main(String[] args) {
		System.out.println(expand("FX", 2, 6));

	}

}
