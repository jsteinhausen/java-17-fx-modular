package com.example.graphics;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangularTest {
    private Rectangular r = null;

    @BeforeEach
    public void before () {
        this.r = new Rectangular(0,0,6,2);
    }

    @Test
    public void computeCircumferenceTest() {
        assertEquals (r.computeCircumference(), 16.0, 0.01);
    }

    @Test
    public void computeAreaTest() {
        assertEquals (r.computeArea(), 12, 0.01);
    }


}
