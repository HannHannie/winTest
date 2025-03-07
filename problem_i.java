/*Suppose we have loaded an array with the digits of an integer, where the highest power is kept in position 0,
next highest in position 1, and so on.
The ones position is always at position array.Length - 1:
Example output: 2025
 Example input: 2, 0, 2, 5
Validation: Verify that every element is a valid digit (0–9). If not, handle the error appropriately (e.g., throw
an exception or return an error code).
Negative Numbers: Extend the function so that an optional sign (e.g., a leading -) can be interpreted
correctly.
Optional Extension: Support conversion of arrays representing hexadecimal numbers (digits 0–9 and letters
A–F).
Documentation & Testing: Include unit tests that cover typical and edge-case scenarios in your report.*/ 

/*idea: nhập chuỗi char, sau đó dò nếu là số thì in ra,
nếu là dấu phẩy thì skip, nếu là hexadecimal thì convert*/
/* check xem trong chuỗi đó có chữ thuộc A->F không, nếu có thì convert String đó thành hệ thập phân */
import java.util.*;

public class problem_i {
    public static void convert(char[] arr) {
        int n = arr.length;
        boolean isHexa = false;
        boolean isNegative = false;
        StringBuilder numStr = new StringBuilder();

        // Kiểm tra nếu có dấu '-' ở đầu thì đánh dấu là số âm
        int startIndex = 0;
        if (arr[0] == '-') {
            isNegative = true;
            startIndex = 1; // Bỏ qua dấu '-' khi xử lý
        }

        // Kiểm tra và xử lý từng ký tự
        for (int i = startIndex; i < n; i++) {
            char c = arr[i];

            if (c == ',') {
                continue; // Bỏ qua dấu phẩy
            } else if (Character.isDigit(c)) {
                numStr.append(c);
            } else if (c >= 'A' && c <= 'F') {
                isHexa = true;
                numStr.append(c);
            } else {
                throw new IllegalArgumentException("Input contains an invalid character: " + c);
            }
        }

        // Kiểm tra xem có số hợp lệ không
        if (numStr.length() == 0) {
            throw new IllegalArgumentException("No valid number found in input.");
        }

        // Chuyển đổi chuỗi số thành số nguyên
        int out;
        if (isHexa) {
            out = Integer.parseInt(numStr.toString(), 16);
        } else {
            out = Integer.parseInt(numStr.toString());
        }

        // Nếu có dấu '-', chuyển sang số âm
        if (isNegative) {
            out = -out;
        }

        System.out.print(out);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        String input = sc.nextLine();
        char[] numArr = input.toCharArray(); // Convert String thành Char Array
        System.out.println("Output: ");
        convert(numArr);
        sc.close();
    }
}
