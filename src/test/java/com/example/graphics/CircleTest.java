package com.example.graphics;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {
    private Circle c = null;

    @BeforeEach
    public void before () {
        this.c = new Circle(0,0,5);
    }

    @Test
    public void computeCircumferenceTest() {
        assertEquals (c.computeCircumference(), 31.41, 0.01);
    }

    @Test
    public void computeAreaTest() {
        assertEquals (c.computeArea(), 78.54, 0.01);
    }


}
