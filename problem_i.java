/*Suppose we have loaded an array with the digits of an integer, where the highest power is kept in position 0,
next highest in position 1, and so on.
The ones position is always at position array.Length - 1:
Example input: 2025
 Example output: 2, 0, 2, 5
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
    public static void convert(char[] arr){
        int n= arr.length;
        StringBuilder numStr = new StringBuilder();
        //isHexa?
        boolean isHexa= false;
        for(int check= 0; check< n; check++){
            char c= arr[check];
            if(!Character.isDigit(check) && (check>='A' && check<='F')){
                isHexa= true;
                break;
            } else throw new IllegalArgumentException("The input contains invalid the character");
        }
        if(!isHexa){
            for(int i=0; i< n; i++){ //i is index
                char c1= arr[i];
                if (Character.isDigit(c1) && (c1>=0 && c1<=9)){
                    numStr.append(c1);
                }
            }
        } else { //isHexa
            for(int i=0; i< n; i++){ //i is index
                char c2= arr[i];
                if (c2>='A' && c2<='F'){
                    numStr.append(c2);
                }
            }
        }

        int out = 0;
        if(isHexa){
            out = Integer.parseInt(numStr.toString(), 16); 
        }
        else if (!isHexa){
            out = Integer.parseInt(numStr.toString());
        }
        
        System.out.println("Converted number: " + out);    
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Input: ");
        String input= sc.nextLine();
        char[] numArr= input.toCharArray(); //convert String into Char Array
        System.out.println("Output: ");
        convert(numArr);
        sc.close();
    }
}
