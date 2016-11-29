package algorithm08.DynamicProgramming;

public class WildCard {

	public static void main(String[] args) {
		System.out.println(match("help", "*p*"));

	}
	
	//*처리만 //s:string, w: wildcard
	public static boolean match(String s, String w){
		int pos = 0;
		//w.charAt(pos)와 s.charAt(pos)를 맞춰나간다.+
		
		while(pos<s.length()&&pos<w.length()&&(w.charAt(pos)=='?'||w.charAt(pos)==s.charAt(pos))) ++pos;
		//while문이 끝나는 이유
		//1. 일반적으로 s.charAt(pos)가 w.charAt(pos)와 대응되지 않는 경우 --> match false
		//2. w끝에 도달 --> 일반적으로 match된다 
		//3. s끝에 도달 --> w의 남은 패턴이 모두 *이라면 성공
		//4. w.charAt(pos)가 *일 경우
		//경우2
		if(pos == w.length()) return pos == s.length();
		//경우3,4
		if(w.charAt(pos)=='*')
			for(int skip = 0; pos+skip<=s.length();++skip){
				if(match(s.substring(pos+skip), w.substring(pos+1))) return true;
			}		
		//이 외에는 false
		return false;
	}
	
	//dynamic programming
	int cache[][] = ArrayGenerator.generate(101);	
	String W, S;
	int metchMemoized(int w, int s){
		int ret = cache[w][s];
		if(ret != -1) return ret;
		while(s<S.length()&&w<W.length()&&(W.charAt(w)=='?'||W.charAt(w)==S.charAt(s))){
			++w;
			++s;
		}
		if(w==W.length()){ return ret=(s==S.length()? 1: 0); }
		
		if(W.charAt(w)=='*')
			for(int skip = 0; s+skip<=S.length();++skip){
				if(match(S.substring(s+skip), W.substring(w+1))) return ret=1;
			}
		return ret=0;
	}

	
}
