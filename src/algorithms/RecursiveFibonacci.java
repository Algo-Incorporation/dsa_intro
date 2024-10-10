import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveFibonacci {
    static ArrayList<Long> fibSeq = new ArrayList<Long>();
    static long num1 = 0, num2 = 1, num3 = 0;

    public static void fibonacci(int count) {

        if (count > 0) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            fibSeq.add(num3);
            fibonacci(count - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.close();
        System.out.print(num1 + " " + num2 + " ");
        fibonacci(count);
        for (long fibNum : fibSeq) {
            System.out.print(fibNum + " ");
        }
    }
}
