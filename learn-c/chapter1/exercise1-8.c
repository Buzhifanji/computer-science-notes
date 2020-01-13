#include <stdio.h>

/* count space，table, lines, in input */
int main()
{
    int c, sl, tl, nl;

    sl = 0;             /* 空格 */
    tl = 0;             /* 制表符 */
    nl = 0;             /* 换行个数 */

    while ((c = getchar()) != EOF) {
        if (c == ' ') {
            ++sl;
        } else if (c == '\t') {
            ++tl;
        } else if (c == '\n') {
            ++nl;
        }
    }
    printf("输入空格次数：%d\n", sl);
    printf("输入制表符次数：%d\n", tl);
    printf("输入换行个数次数：%d\n", nl);
}