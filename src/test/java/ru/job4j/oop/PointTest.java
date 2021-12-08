package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance3D() {
        double expected = 5.2;
        Point a = new Point(2, 2, 2);
        Point b = new Point(5, 5, 5);
        double dist = a.distance3D(b);
        Assert.assertEquals(expected, dist, 0.01);
    }
}