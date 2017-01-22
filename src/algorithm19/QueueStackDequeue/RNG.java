package algorithm19.QueueStackDequeue;

import static java.lang.Math.pow;

public class RNG {

    RNG(){
        seed = 1983;
    }
    double seed;
    int int_seed;

    public double next(){
        double ret = seed;
        seed = (seed*214013 + 2531011)% (pow(2,32));
        return ret;
    }

    public int next_int(){
        int ret = int_seed;
        seed = (seed*214013 + 2531011)% (pow(2,32));
        return ret;
    }

}
