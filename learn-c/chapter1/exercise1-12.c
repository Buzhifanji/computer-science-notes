#include <stdio.h>

#define IN  0   /* inside a word */
#define OUT 1   /* outside a word */

/* output a word in a line */
int main()
{
    int c, state;

    state = OUT;
    while ((c = getchar()) != EOF)
    {
        if (c == ' ' || c == '\t' || c == '\n') {
            if(state == IN) {
                putchar('\n');      // 一个单词的输入结束
                state = OUT;
            }
        }
        else if (state == OUT)
        {
            state = IN;
            putchar(c);             // 一个单词输入开始
        } else {               
            putchar(c);             // 在输入一个单词时
        }
    }
}