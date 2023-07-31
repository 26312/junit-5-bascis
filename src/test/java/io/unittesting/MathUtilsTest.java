package io.unittesting;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.Assumptions.*;

import java.rmi.ServerError;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@EnabledOnOs(OS.WINDOWS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {


    MathUtils mathUtils;

    @BeforeAll
    void beforeAllInit(){
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("Nested Version: Addition of 2 Numbers")
    class AddNested{

        @Test
        @DisplayName("When Adding Positive Numbers")
        void testAddPositive(){
            assertEquals(4,mathUtils.add(2,2),"should return the right sum");
        }

        @Test
        @DisplayName("When Adding Negative Numbers")
        void testAddNegative(){
            assertEquals(-6,mathUtils.add(-3,-3),"should return the right sum");
        }

    }



    @Test
    @DisplayName("Adding 2 Numebers")
    void add() {
        int expected = 4;
        int actual = mathUtils.add(2,2);
        assertEquals(expected, actual,"The add method should add 2 numbers");
        System.out.println("Addition Successful");
    }

    @Test
    @DisplayName("Computing Area of the cirecle")
    void testcomputeCircleArea() {
       assertEquals(314.15926535897932384626433832795,
               mathUtils.computeCircleArea(10   ),
               "Should return right cirlce area");
        System.out.println("Area of Circle match the given input");
    }

    @Test
    void divide() {
        assertThrows(ArithmeticException.class,
                ()->mathUtils.divide(1,0),
                "Divide by zero should throw Exception");
        System.out.println("Division Successful... ");
    }

    @Test
    void multiple() {
        // int expected = 20;
       assertAll(
               () -> assertEquals(20, mathUtils.multiple(4,5)),
               () -> assertEquals(15, mathUtils.multiple(3,5)),
               () -> assertEquals(125, mathUtils.multiple(25,5)),
               () -> assertEquals(100, mathUtils.multiple(20,5))
       );
        System.out.println("Multiplication successful...");
    }

    @AfterEach
    void cleanUp(){
        System.out.println("Cleaning Up.....");
    }

    @Test
    @DisplayName("TDD method: Not in use")
    @Disabled
    void testFail(){
        fail("This test shouldfail: 'Testinf @Disabled' ");
    }

    @Test
    @DisplayName("Check Server Status")
    void serverUp(){
        boolean isServerUp = false;
        assumeTrue(isServerUp);
    }
}