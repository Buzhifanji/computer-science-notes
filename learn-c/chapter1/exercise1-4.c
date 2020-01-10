#include <stdio.h>
/* 摄氏温度转华氏温度表 */
int main()
{
    float fahr, celsius;
    float lower, upper, step;

    lower = -40;
    upper = 300;
    step = 20;

    celsius = lower;
    while (celsius <= upper)
    {
        fahr = celsius * 9.0 / 5.0 + 32.0;
        printf(" %3.1f %6.2f\n", celsius, fahr);
        celsius = celsius + step;
    }
}