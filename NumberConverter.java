import java.util.*;

public class NumberConverter {
    
    public static int convertArrayToInteger(char[] arr, boolean isHex) throws IllegalArgumentException {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input is not empty!");
        }

        boolean isNegative = false;
        int startIndex = 0;

        if (arr[0] == '-') {
            if (arr.length == 1) {
                throw new IllegalArgumentException("'-' But do not have number behind!");
            }
            isNegative = true;
            startIndex = 1; 
        }

        StringBuilder numStr = new StringBuilder();
        

        for (int i = startIndex; i < arr.length; i++) {
            char c = arr[i];

    
            if (isHex) { 
                if (!Character.isDigit(c) && !(c >= 'A' && c <= 'F')) {
                    //kiểm tra c, nếu nó không phải là số và không thuộc từ A tới F thì throw lỗi
                    throw new IllegalArgumentException("Character is not suitable in Hexadecimal: " + c);
                }
            } else { 
                if (!Character.isDigit(c)) { //tương tự
                    throw new IllegalArgumentException("Character is not suitable in DecimalDecimal " + c);
                }
            }

            numStr.append(c); //thêm vào numStr
        }

        int result;
        if (isHex) {
            result = Integer.parseInt(numStr.toString(), 16); 
        } else {
            result = Integer.parseInt(numStr.toString()); 
        }

        if (isNegative) {
            result = -result;
        }
        
        return result; 
    }

    
    public static void main(String[] args) {
        testConvert(new char[]{'2', '0', '2', '5'}, false);
        testConvert(new char[]{'0', '1', '2', '3'}, false); 
        testConvert(new char[]{'-', '2', '5'}, false); 
        testConvert(new char[]{'A', 'F', '3'}, true); 

        testConvert(new char[]{'2', 'X', '5'}, false); 
        testConvert(new char[]{'A', 'G', '5'}, true); 
        testConvert(new char[]{'-'}, false); 
    }

    private static void testConvert(char[] input, boolean isHex) {
        try {
            int result = convertArrayToInteger(input, isHex);
            System.out.println("Input: " + Arrays.toString(input) + " → Output: " + result);
        } catch (Exception e) {
            System.out.println("Input: " + Arrays.toString(input) + " → error: " + e.getMessage());
        }
    }
}

