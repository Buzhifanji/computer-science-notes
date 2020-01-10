#include <stdio.h>

int main() 
{
    float fahr, celsius;
    float lower, upper, step;

    lower = 0;
    upper = 300;
    step = 20;

    fahr = lower;
    printf("温度转化表\n");
    while (fahr <= upper)
    {
        celsius = (5.0 / 9.0) * (fahr - 32.0);
        printf(" %3.1f %6.2f\n", fahr, celsius);
        fahr = fahr + step;
    }
}