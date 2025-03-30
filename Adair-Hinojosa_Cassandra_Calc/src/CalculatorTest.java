import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    @org.junit.jupiter.api.Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(11, calculator.add(10, 1));
        assertEquals(-2, calculator.add(-3, 1));
        assertEquals(0, calculator.add(0, 0));
    }

    @org.junit.jupiter.api.Test
    void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.divide(15, 3));
        assertEquals(-6, calculator.divide(-12, 2));

    }
        @org.junit.jupiter.api.Test
        void testMultiply () {
            Calculator calculator = new Calculator();
            assertEquals(11, calculator.multiply(1, 11));
            assertEquals(-20, calculator.multiply(-10, 2));
            assertEquals(0, calculator.multiply(0, 100));
        }

        @org.junit.jupiter.api.Test
        void testSubtract () {
            Calculator calculator = new Calculator();
            assertEquals(-1, calculator.subtract(10, 11));
            assertEquals(50, calculator.subtract(100, 50));
            assertEquals(0, calculator.subtract(11, 11));
        }
        @org.junit.jupiter.api.Test
    void testCalculateInvalidOperator() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(2, 5, "="));
    }


}
