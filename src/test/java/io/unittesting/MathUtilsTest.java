package io.unittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {


    MathUtils mathUtils;

    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }


    @Test
    void test() {
        int expected = 4;
        int actual = mathUtils.add(2,2);
        assertEquals(expected, actual,"The add method should add 2 numbers");
        System.out.println("Addition Successful");
    }


    @Test
    void testcomputeCircleArea() {
       assertEquals(314.15926535897932384626433832795,
               mathUtils.computeCircleArea(10   ),
               "Should return right cirlce area");
    }

    @Test
    void divide() {
        assertThrows(ArithmeticException.class,
                ()->mathUtils.divide(1,0),
                "Divide by zero should throw Exception");
    }

    @Test
    void multiple() {
        int expected = 20;
        assertEquals(expected,
                mathUtils.multiple(4,5),
                "Multiplication of numbers");
    }
}