import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

    }

    //Method for Addition
    public int add(int num1, int num2) {
        return num1 + num2;

    }
    //Setting up Methods for Div,Mul,Sub
    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int calculate(int num1, int num2, String operator) {
        if (operator.equals("+")) {
            return add(num1, num2);
        } else if (operator.equals("-")) {
            return subtract(num1, num2);
        } else if (operator.equals("*")) {
            return multiply(num1, num2);
        } else if (operator.equals("/")) {
            return divide(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid operator");
        }
    }

}