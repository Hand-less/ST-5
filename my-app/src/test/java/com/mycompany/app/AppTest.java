package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), 1e-9);
    }

    @Test
    void testGoodTrue() {
        Sqrt sqrt = new Sqrt(0);
        assertTrue(sqrt.good(Math.sqrt(4), 4.0));
    }

    @Test
    void testGoodFalse() {
        Sqrt sqrt = new Sqrt(0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    @Test
    void testImprove() {
        Sqrt sqrt = new Sqrt(0);
        double guess = 2.0;
        double improved = sqrt.improve(guess, 4.0);
        assertTrue(improved > 0);
    }

    @Test
    void testCalcSimple() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcWithEpsilon() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-6);
    }

    @Test
    void testZero() {
        Sqrt sqrt = new Sqrt(0.0);
        assertEquals(0.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testOne() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testLargeNumber() {
        Sqrt sqrt = new Sqrt(1_000_000);
        assertEquals(1000.0, sqrt.calc(), 1e-3);
    }

    @Test
    void testNegative() {
        assertThrows(StackOverflowError.class, () -> {
            Sqrt sqrt = new Sqrt(-4.0);
            sqrt.calc();
        });
    }
}
