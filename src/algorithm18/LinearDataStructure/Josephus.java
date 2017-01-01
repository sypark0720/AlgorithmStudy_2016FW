package algorithm18.LinearDataStructure;

import java.util.LinkedList;
import java.util.List;

public class Josephus {

    public static void main(String[] args){
        List list= josephus(6,3);
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }

    public static List<Integer> josephus(int n, int k){

        List<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<n; i++)
            list.add(i);

        int kill = 0;
        int num = n;

        while (num>2){
            int killed = list.remove(kill);
            if(kill == list.size()) kill = 0;

            --num;

            for(int i=0; i<k-1; ++i){
                ++kill;
                if(kill == list.size()) kill=0;
            }
        }

        return list;
    }
}
