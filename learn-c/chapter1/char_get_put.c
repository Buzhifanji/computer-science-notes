/* 字符输入输出 */
#include <stdio.h>

/* copy input to output; 1st version */
int main()
{
    int c;

    c = getchar();
    while (c != EOF) {
        putchar(c);
        c = getchar();
    }
}