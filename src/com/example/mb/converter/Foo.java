package com.example.mb.converter;

public class Foo {

    // Init ---------------------------------------------------------------------------------------

    private String key; // You can also use any Number type, e.g. Long.
    private String value;

    // Constructors -------------------------------------------------------------------------------

    public Foo() {
        // Default constructor, keep alive.
    }

    public Foo(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getters ------------------------------------------------------------------------------------

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    // Setters ------------------------------------------------------------------------------------

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Helpers ------------------------------------------------------------------------------------

    // This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof Foo && (key != null) ? key.equals(((Foo) other).key) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return key != null ? this.getClass().hashCode() + key.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "Foo[" + key + "," + value + "]";
    }

}