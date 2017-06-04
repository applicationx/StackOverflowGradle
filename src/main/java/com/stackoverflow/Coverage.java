package com.stackoverflow;

import java.util.Random;

/**
 * Created by jonasd on 2017-06-05.
 */
public class Coverage {

    public int getSomeNumber() {
        Random random = new Random(124208l);
        return random.nextInt();
    }

    public int getResultBasedOnParameter(boolean path) {
        if (path) {
            return 10;
        } else {
            return 20;
        }
    }
}
