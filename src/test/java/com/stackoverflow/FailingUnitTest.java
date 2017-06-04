package com.stackoverflow;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jonasd on 2017-06-05.
 */
public class FailingUnitTest {

    @Test
    public void failingTest() {
        Assert.assertEquals(true, true);
    }
}
