package algorithm19.QueueStackDequeue;

import java.util.LinkedList;
import java.util.Queue;

public class ITES {
    public static void main(String[] args){

    }

    static int countRanges(int k, int n) {
        RNG rng = new RNG();
        Queue<Double> range = new LinkedList<Double>();
        int ret = 0, rangeSum = 0;

        for (int i = 0; i < n; i++) {

            double newSignal = rng.next();
            rangeSum += newSignal;
            range.add(newSignal);


            while (rangeSum > k) {
                rangeSum -= range.element();
                range.remove();
            }

            if (rangeSum == k) ret++;
        }

        return ret;
    }
}

