package strings;

public class ReverseInteger {

    public static int reverse(int x) {
        long rev = 0;

        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return (rev >= Integer.MIN_VALUE && rev <= Integer.MAX_VALUE)
                ? (int) rev
                : 0;
    }

    public static void main(String[] args) {
        int number = 890;
        System.out.println(reverse(number));
    }
}
