package com.stackoverflow;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import static org.junit.Assert.*;

/**
 * Created by jonasd on 2017-06-05.
 */
public class CoverageTest {
    @Test
    public void getSomeNumber() throws Exception {
        Coverage coverage = new Coverage();
        assertThat("Should be above zero", coverage.getSomeNumber(), Matchers.greaterThan(0));
    }

    @Test
    public void getResultBasedOnParameter() throws Exception {
        Coverage coverage = new Coverage();
        assertThat("Should be 10", coverage.getResultBasedOnParameter(true), Matchers.equalTo(10));
        assertThat("Should be 20", coverage.getResultBasedOnParameter(false), Matchers.equalTo(20));

    }

}