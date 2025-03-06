import java.util.*;

public class chatgpt {
    public static void convert(char[] arr) {
        int n = arr.length;
        StringBuilder numStr = new StringBuilder();
        boolean isHexa = false;

        for (int i = 0; i < n; i++) {
            char c = arr[i];

            if (Character.isDigit(c) || (c >= 'A' && c <= 'F')) {
                if (c >= 'A' && c <= 'F') {
                    isHexa = true;
                }
                numStr.append(c);
            } else if (c == '-') {
                // Hỗ trợ số âm (chỉ hợp lệ nếu ở đầu)
                if (i == 0) {
                    numStr.append(c);
                } else {
                    throw new IllegalArgumentException("Invalid negative sign position.");
                }
            } else {
                throw new IllegalArgumentException("The input contains invalid characters.");
            }
        }

        // Kiểm tra chuỗi sau khi xử lý
        if (numStr.length() == 0 || (numStr.length() == 1 && numStr.charAt(0) == '-')) {
            throw new IllegalArgumentException("Invalid input: No valid digits found.");
        }

        // In từng chữ số trong mảng
        System.out.println("Digits: " + Arrays.toString(numStr.toString().toCharArray()));

        int out;
        if (isHexa) {
            out = Integer.parseInt(numStr.toString(), 16);
        } else {
            out = Integer.parseInt(numStr.toString());
        }

        System.out.println("Converted number: " + out);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String input = sc.nextLine().toUpperCase(); // Chuyển về uppercase để tránh lỗi với chữ thường
        char[] numArr = input.toCharArray(); // Chuyển chuỗi thành mảng ký tự
        convert(numArr);
        sc.close();
    }
}
