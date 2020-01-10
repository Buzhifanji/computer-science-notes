#include <stdio.h>

int main() {
    float fahr, celsius;
    float lower, upper, step;

    lower = 0;
    upper = 300;
    step = 20;
    fahr = lower;
    while (fahr <= upper)
    {
        celsius = (5.0 / 9.0) * (fahr - 32.0);
        printf(" %3.0f %6.1f\n", fahr, celsius);
        fahr = fahr + step;
    }
}
/*
*   notes
*   %d          按照十进制整型数打印
*   %6d         按照十进制整型数打印，至少6个字宽
*   %f          按照浮点数打印
*   %6f         按照浮点数打印，至少6个字宽
*   %.2f        按照浮点数打印，小数点后有两位小数
*   %6.2f       按照浮点数打印，至少6个字宽，小数点有两位小数
*/