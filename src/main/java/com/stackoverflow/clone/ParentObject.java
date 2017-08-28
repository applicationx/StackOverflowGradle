package com.stackoverflow.clone;

import java.util.Calendar;
import java.util.Date;

public class ParentObject {

    protected Long creationTime = new Date().getTime();

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }
}
