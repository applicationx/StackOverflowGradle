package com.stackoverflow.clone;

public class OtherObject implements Cloneable {

    private String name;
    private Long value;

    public OtherObject(String name, Long value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public OtherObject clone() {
        try {
            OtherObject clone = (OtherObject) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getCause());
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OtherObject that = (OtherObject) o;

        if (!name.equals(that.name)) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }
}
