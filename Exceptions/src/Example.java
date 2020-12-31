import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException e){

        }

    }
    private static int divide(){
        int x, y; // declaring int x outside of try and catch block
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x +  ", y is "+ y);
            return x / y;
        } catch (NoSuchElementException e){ // checking for elements that aren't digits
            throw new ArithmeticException("No suitable input");
        } catch (ArithmeticException e){  // checking for elements that are zero
            throw new ArithmeticException("Attempted to divide by zero");
        }
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer "); // when entering a non-digit,
        while (true){
            try {
                return s.nextInt(); // error brings me back here at Example.getInt(Example.java:17)
            } catch (InputMismatchException e){

                // go around again and read past the end of the line in the input first
                s.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            } // now the stack trace is a lot easier to follow
        }
    }
}
