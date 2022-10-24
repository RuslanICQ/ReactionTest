
package reactiontest;

import java.util.Random;

class RN{
    static int RNum(int max_num){ // max_num is not included
        Random rand = new Random();
        int rn = rand.nextInt(max_num);
        return rn;
    }
}
