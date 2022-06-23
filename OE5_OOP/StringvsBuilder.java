package OE5_OOP;

public class StringvsBuilder {

    public static void main(String[] args) {
        String str1 = "Hello";
        StringBuilder str2 = new StringBuilder("Hello");

        System.out.println(str1 + " " + str1.hashCode());
        System.out.println(str2.toString() + " " + str2.hashCode());

        str1 = str1 + "World";
        str2.append("World");

        System.out.println(str1 + " " + str1.hashCode());
        System.out.println(str2.toString() + " " + str2.hashCode());

    }// end method main;

    public String reverse(String str) {
        String strRev = "";
        for (int i = str.length() - 1; i >= 0; i--)
            strRev += str.charAt(i);
        // endfor
        return strRev;
    }

    public StringBuilder Reverse1(String s) {
        StringBuilder str1 = new StringBuilder(s);
        return str1.reverse();
    }

}