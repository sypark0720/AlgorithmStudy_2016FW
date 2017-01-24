package algorithm09.DynamicProgrammingTechnique;

import java.util.ArrayList;
import java.util.List;

public class Blockgame {

	List<Integer> moves = new ArrayList<Integer>();
	int cell(int y, int x){ return 1<<(y*5+x);}
	
	//게임판에 놓을 수 있는 블록들의 위치 미리 계산
	void precalc(){
		//세 칸짜리L자 모양 블록들
		for(int y=0; y<4; ++y)
			for(int x=0; x<4; ++x){
				ArrayList<Integer> cells = new ArrayList<Integer>();
				for(int dy=0; dy<2; ++dy)
					for(int dx=0; dx<2; ++dx)
						cells.add(cell(y+dy, x+dx));
				int square = cells.get(0)+cells.get(1)+cells.get(2)+cells.get(3);
				for(int i=0; i<4; i++) 
					moves.add(square-cells.get(i));
			}
		
		//두 칸
		for(int i=0; i<5; ++i)
			for(int j=0; j<4; ++j){
				moves.add(cell(i,j)+cell(i, j+1));
				moves.add(cell(j,i)+cell(j+1, i));
		}
	}
	
	char[] cache = new char[1<<25];
//	char play(int board){
//		char ret = cache[board];
//		ret=0;
//		
//		for(int i=0; i<moves.size(); ++i)
//			if((moves.get(i)&board)==0)
//				if(!play(board|moves.get(i))){
//					ret = 1;
//					break;
//				}
//		return ret;
//	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
