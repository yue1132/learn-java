package com.java8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        System.out.println(inverse(2D));
        System.out.println(inverse(0D));
        System.out.println(inverse(3D));
        System.out.println(inverse(0D).orElse(111D));
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }
}
