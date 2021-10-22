package ReverseInteger;


public class Demo {

    public static void main(String[] arg) {
        reverse(-2147483648);
    }

    public static int reverse(int x) {
        boolean neg = x < 0;

        if (-x == x) {
            return 0;
        }

        if (neg) x = x * -1;

        int rem;
        long output = 0L;
        do {
            output *= 10L;
            rem = x % 10;
            output += rem;
            x = x / 10;
        } while (x != 0);

        if (output > Integer.MAX_VALUE) {
            return 0;
        }

        return neg ? (int) -output : (int) output;
    }
}
