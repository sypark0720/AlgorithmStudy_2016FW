package algorithm28.DepthFirstSearch;

import java.util.ArrayList;

public class Dictionary {
	
	static int[][] constructgraph(String[] words){
		int[][] adj = new int[26][26];
		
		for(int j=1; j<words.length; ++j){
			int i = j-1;
			int len = Integer.min(words[i].length(), words[j].length());
			
			for(int k=0; k<len; ++k)
				if(words[i].charAt(k) != words[j].charAt(k)){
					int a = words[i].charAt(k) - 'a';
					int b = words[j].charAt(k) - 'a';
					adj[a][b] = 1;
					break;
				}
		}
		
		return adj;
	}
	
	
	public static void main(String[] args) {
		String[] words = { "gg", "kia", "lotte", "lg", "hanhwa" };
		
		int[][] dgraph = constructgraph(words);


	}

}
