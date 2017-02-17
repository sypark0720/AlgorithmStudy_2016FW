package algorithm23.Heap;

import algorithm19.QueueStackDequeue.RNG;

import java.util.PriorityQueue;

public class RunningMedian {
    static int runningMedian(int n, RNG rng){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int ret = 0;

        for(int cnt = 1; cnt <=n; ++cnt){
            if(maxHeap.size()== minHeap.size())
                maxHeap.add(rng.next_int());
            else minHeap.add(rng.next_int());

            if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek()<maxHeap.peek()){
                int a = maxHeap.peek(), b = minHeap.peek();
                maxHeap.remove(); minHeap.remove();
                maxHeap.add(b);
                minHeap.add(a);
            }
            ret = (ret+maxHeap.peek())%20090711;
        }

        return ret;
    }

    public static void main(String[] args){

    }
}
