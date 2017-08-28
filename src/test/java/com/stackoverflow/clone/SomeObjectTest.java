package com.stackoverflow.clone;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeObjectTest {


    @Test
    public void checkCloneValidity() throws Exception {
        SomeObject firstObject = new SomeObject(new OtherObject("firstName", 1L));
        SomeObject secondObject = firstObject.clone();
        assertEquals("Original and cloned object should have same OtherObject in list",true, firstObject.getOtherObjects().get(0).equals(secondObject.getOtherObjects().get(0)));
        assertEquals(firstObject.getCreationTime(), secondObject.getCreationTime());
        firstObject.getOtherObjects().get(0).setName("secondName");
        firstObject.setCreationTime(1L);
        assertEquals("Original and cloned object should NOT have same OtherObject in list after chainging first object",false, firstObject.getOtherObjects().get(0).equals(secondObject.getOtherObjects().get(0)));
        assertNotEquals("Changing parent object value should not leak over to new object", firstObject.getCreationTime(), secondObject.getCreationTime());
    }
}