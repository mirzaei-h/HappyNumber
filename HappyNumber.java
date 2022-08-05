package functionalPrograming;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class HappyNumber {

//    UnaryOperator<Integer> sumOfDigitSquares = number -> {
    static Function<Integer,Integer> sumOfDigitSquares = number -> {
        Integer sum = 0;

        while (number != 0) {
            Integer digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    };
    public static boolean numberIsHappy(int number) {



        int slow, fast;

        //  initialize slow and fast by n
        slow = fast = number;
        do
        {
            //  move slow number
            // by one iteration
            slow = sumOfDigitSquares.apply(slow);

            //  move fast number
            // by two iteration
            fast = sumOfDigitSquares.apply(sumOfDigitSquares.apply(fast));

        }
        while (slow != fast);

        //  if both number meet at 1,
        // then return true
        return (slow == 1);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("please enter a number:");
        Integer number = scanner.nextInt();
        System.out.println(numberIsHappy(number));

    }

}
