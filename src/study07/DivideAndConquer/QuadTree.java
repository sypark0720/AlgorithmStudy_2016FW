package study07.DivideAndConquer;

import java.util.Vector;

public class QuadTree {

	public static void main(String[] args) {
		String original = "xbwxwbbwb";
		System.out.println(reverse(original));
		
	}
	
	public static String reverse(String original){
		//base
		if(original.charAt(0)=='b'||original.charAt(0)=='w') return original.charAt(0)+"";
		//loop --> 첫 번째 글자가 'x'
		int index = 1;
		String quad1, quad2, quad3, quad4;		
		quad1 = reverse(original.substring(index));
		index += quad1.length();
		quad2 = reverse(original.substring(index));
		index += quad2.length();
		quad3 = reverse(original.substring(index));
		index += quad3.length();
		quad4 = reverse(original.substring(index));
		
		return 'x'+quad3+quad4+quad1+quad2;  
	}

}
