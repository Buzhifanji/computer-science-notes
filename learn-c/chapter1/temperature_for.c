#include <stdio.h>

int main()
{
    int fahr;
    for (fahr = 0; fahr <= 300; fahr = fahr + 20) {
        printf(" %3d %6.1f\n", fahr, (5.0 / 9.0) * (fahr - 32));
    }
}

/*
* for 语句：初始化部分（第一部分），条件部分（第二部分），增加步长部分（第三部分）
*/