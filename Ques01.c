/*Write a program that inputs an n-digit number then output its n digits from least to most
significant
Input: 87952 - Output: 2 5 9 7 8 */
#include <stdio.h>
#include <string.h>

int main() {
    char numArray[100]; 
    scanf("%s", numArray); //nhập array không cần &
    int length = strlen(numArray); //lấy độ dài của chuỗi: strlen()
    for (int i = length - 1; i >= 0; i--) {
        printf("%c ", numArray[i]);
    }
    printf("\n");
    return 0;
}
