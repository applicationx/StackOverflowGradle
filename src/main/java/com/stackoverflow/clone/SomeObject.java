package com.stackoverflow.clone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SomeObject extends ParentObject implements Cloneable {

    private List<OtherObject> otherObjects;

    public SomeObject(OtherObject... otherObjects) {
        this.otherObjects = Arrays.asList(otherObjects);
    }

    @Override
    public SomeObject clone() {
        try {
            SomeObject clone = (SomeObject) super.clone();
            clone.otherObjects = otherObjects.stream().map(oo -> oo.clone()).collect(Collectors.toList());
            for (int i = 0; i < clone.otherObjects.size(); i++) {
                clone.getOtherObjects().set(i, getOtherObjects().get(i).clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getCause());
        }
    }

    public List<OtherObject> getOtherObjects() {
        return otherObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SomeObject that = (SomeObject) o;

        return otherObjects.equals(that.otherObjects);
    }

    @Override
    public int hashCode() {
        return otherObjects.hashCode();
    }

    public Long getCreationTime() {
        return creationTime;
    }
}
