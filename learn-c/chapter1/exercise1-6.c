#include <stdio.h>

int main()
{
    int c;

    printf("请输入字符： \n");
    c = (getchar() != EOF);
    printf("%d\n", c);
}