import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        //scanner setup
        Scanner sc = new Scanner(System.in);

    //Gather user input
        // print statements
    int num1;
    int num2;

        System.out.println("Enter the first number: ");
    num1 = sc.nextInt();
        System.out.println("Enter the second number: ");
    num2 = sc.nextInt();
        System.out.println("Choose an Operator(+-*/): ");
    char op = sc.next().charAt(0);
    operate(num1,num2, op);

}
     //set up else-if calculations
public static int operate(int num1, int num2, char operator) {

    int result = 0;
    if (operator == '+') {
        result = num1 + num2;
    }
    else if (operator == '-') {
        result = num1 - num2;
    }
    else if (operator == '*') {
        result = num1 * num2;
    }
    else if (operator == '/') {
        result = num1 / num2;
    }
    else {
        throw new IllegalArgumentException("Invalid operator");
    }
    //print results
    System.out.println("Result: " + result);
    return result;

}
}
