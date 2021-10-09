import java.util.Scanner;
import java.lang.Math;

public class Calculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Type a new expression");
        String expr = input.nextLine().replaceAll(" ", "");
        input.close();

        eval(expr);

    }

    public static void eval(String expr) {

        int num_begin = 0;
        double result = 0, operand;
        char last_operator = '+';

        for (int i = num_begin; i < expr.length(); i += 1) {

            if (expr.charAt(i) == '+' || expr.charAt(i) == '-' || expr.charAt(i) == '/' || expr.charAt(i) == '*' ||
                expr.charAt(i) == '%' || expr.charAt(i) == '^') {

                if (i == 0 || i - num_begin == 0) {

                    last_operator = expr.charAt(i);
                    num_begin = i + 1;

                    continue;

                }

                operand = Double.parseDouble(expr.substring(num_begin, i));

                if (num_begin == 0 || num_begin == 1) {

                    result = operand;

                } else {

                    result = operation(result, operand, last_operator);
                    System.out.println(result);

                }

                last_operator = expr.charAt(i);
                num_begin = i + 1;
            }

            if(i == expr.length() - 1) {

                operand = Double.parseDouble(expr.substring(num_begin));
                System.out.println(operation(result, operand, last_operator));

            }

        }
    }

    public static double operation(double a, double b, char operator) {

        switch (operator) {

            case '+': return a + b;
            case '-': return a - b;
            case '/': return a / b;
            case '*': return a * b;
            case '%': return a % b;
            case '^': return Math.pow(a, b);
            default: return 0;
            
        }

    }

}