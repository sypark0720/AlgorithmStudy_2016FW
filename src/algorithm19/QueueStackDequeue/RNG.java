package algorithm19.QueueStackDequeue;

import static java.lang.Math.pow;

public class RNG {

    RNG(){
        seed = 1983;
    }
    double seed;

    double next(){
        double ret = seed;
        seed = (seed*214013 + 2531011)% (pow(2,32));
        return ret;
    }

}
