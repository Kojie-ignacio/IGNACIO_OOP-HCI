package OE5_OOP;

import java.util.*;

public class reverse {

    public static void main(String[] args) {
        String x;
        StringBuilder t = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the string.
        System.out.print("Enter the string: ");
        x = sc.nextLine();

        // Call the method backwardsDay.
        backwardsDay(x);

        // Call the method reverse.
        String y = reverse(x);
        System.out.println(y);

        // Call the method Reverse1
        t = t.append(Reverse1(x));
        System.out.println(y);
    }

    public static void backwardsDay(String Original) {
        String backwards = "";
        for (int i = Original.length(); i >= 1; i--) {
            backwards += Original.substring(i - 1, i);
        }
        System.out.println(backwards);
    }

    public static String reverse(String str) {
        String strRev = "";
        for (int i = str.length() - 1; i >= 0; i--)
            strRev += str.charAt(i);

        return strRev;
    }

    public static StringBuilder Reverse1(String s) {
        StringBuilder str1 = new StringBuilder(s);
        return str1.reverse();
    }

}
