public class LargeNumberMultiplication {

    public static String multiply(String x, String y) {
    int m = x.length();
    int n = y.length();
    // Initialize an array to store intermediate products
    int[] products = new int[m + n];
    // Iterate over each digit of x and y
    for (int i = m - 1; i >= 0; i--) {
    for (int j = n - 1; j >= 0; j--) {
    int digit1 = x.charAt(i) - '0';
    int digit2 = y.charAt(j) - '0';
    // Calculate the product of the current digits
    int product = digit1 * digit2;
    // Update the corresponding position in the products array
    int pos = i + j + 1; 
    products[pos] += product;
    // Handle carry-over
    int carry = products[pos] / 10;
    products[pos] %= 10;
    // Propagate carry to the left
    int k = pos - 1;
    while (carry > 0 && k >= 0) { 
    products[k] += carry;
    carry = products[k] / 10;
    products[k] %= 10;
    k--;
    }
    }
    }
    // Convert the products array to a string representation
    StringBuilder result = new StringBuilder();
    for (int digit : products) {
    result.append(digit);
    }
    while (result.length() > 1 && result.charAt(0) == '0') {
    result.deleteCharAt(0);
    }
    return result.toString();
    }
    
    public static void main(String[] args) {
    String x = "32543314534535657567468678687648";
    String y = "56356756735763653673573736735673";
    String product = multiply(x, y);
    System.out.println("Product: " + product);
    }
    }


