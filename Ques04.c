#include<stdio.h>
#include<math.h>
int main(){
    int x, y, cal;
    scanf("%d %d", &x, &y);
    cal= 3*pow(x,2)*pow(y,2)-2*x*pow(y,2)-7*pow(x,2)*y-4*pow(y,2)+15*x*y+2*pow(x,2)-3*x+10*y+6;
    printf("Result is: %d", cal);
}