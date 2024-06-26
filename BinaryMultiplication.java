// this is  binary Multiplication algorithem to multiply x and y make by ismail.

public class BinaryMultiplication {
    // we will have three functions
    // 1- multiply function

    public static String multiply(String x, String y) {

        // convert the string into integer numbers
        int num1 = Integer.parseInt(x, 2);
        int num2 = Integer.parseInt(y, 2);

        // pass these two number into the Multiplayer
        int result = binaryMultiplayer(num1, num2);

        return Integer.toBinaryString(result);

    }
    // 2- binaryMultiplayer funtion.

    public static int binaryMultiplayer(int x, int y) {
        int n = Math.max(Integer.toBinaryString(x).length(), Integer.toBinaryString(y).length());

        // check for the base case .
        if (x == 0 || y == 0)
            return 0;
        else if (n == 1)
            return x * y;

        // divide the two numbers into halfs .

        int xf = x >> (n / 2);
        int xr = x - (xf << (n / 2));
        int yf = y >> (n / 2);
        int yr = y - (yf << (n / 2));

        // then conquer

        int P1 = binaryMultiplayer(xf, yf);
        int P2 = binaryMultiplayer(xr, yr);
        int P3 = binaryMultiplayer(xf + xr, yf + yr);

        return (P1 << n ) + ((P3 - P1 - P2) << (n / 2)) + P2;

    }

    // 3- main funtion.
    public static void main(String[] args) {

        String x = "101001001011011";
        String y = "111110101010101";

        // pass those two number into multiply function as arguments.
        String product = multiply(x, y);
        System.out.println("The product of " + x + " and " + y + " is: " + product);
    }
}
