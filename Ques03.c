/*tìm số nguyên tố
Input: 10 - Output: 2 3 5 7 */
#include <stdio.h>
#include <math.h>

int main() {
    int N;
    scanf("%d", &N);

    // Kiểm tra số nguyên tố cho từng số từ 2 đến N-1
    for (int i = 2; i < N; i++) {
        int isPrime = 1;  // Giả sử i là số nguyên tố (trả giá trị về true)
        for (int j = 2; j <= sqrt(i); j++) {
            if (i % j == 0) {
                isPrime = 0;  // Nếu tìm thấy một ước số, i không phải số nguyên tố
                break; //break vòng for của j
            }
        }
        
        if (isPrime) {
            printf("%d ", i);  // In ra số nguyên tố
        }
    }

    return 0;
}
