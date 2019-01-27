package com.javarush.task.task21;

class Mutable {
    private int data;

     Mutable(int initVal) {
        data = initVal;
    }

    public Mutable add(int x) {
        data += x;
        return this;
    }

    public Mutable multiply(int x) {
        data *= x;
        return this;
    }

    public Immutable2 makeImmutable2() {
        return new Immutable2(data);
    }
}

public class Immutable2 {
    private int data;

    Immutable2(int initVal) {
        data = initVal;
    }

    private int read() {
        return data;
    }

    public boolean nonzero() {
        return data != 0;
    }

    private Immutable2 add(int x) {
        return new Immutable2(data + x);
    }

    private Immutable2 multiply(int x) {
        return new Immutable2(data * x);
    }

    private Mutable makeMutable() {
        return new Mutable(data);
    }

    private static Immutable2 modify1(Immutable2 y) {
        Immutable2 val = y.add(12);
        val = val.multiply(3);
        val = val.add(11);
        val = val.multiply(2);
        return val;
    }

    // Это приводит к тому же результату:
    private static Immutable2 modify2(Immutable2 y) {
        Mutable m = y.makeMutable();
        m.add(12).multiply(3).add(11).multiply(2);
        return m.makeImmutable2();
    }

    public static void main(String[] args) {
        Immutable2 i2 = new Immutable2(47);
        Immutable2 r1 = modify1(i2);
        Immutable2 r2 = modify2(i2);
        System.out.println("i2 = " + i2.read());
        System.out.println("r1 = " + r1.read());
        System.out.println("r2 = " + r2.read());
        String s = new String(new byte[4]);
        System.out.print(s);
    }
} ///:~