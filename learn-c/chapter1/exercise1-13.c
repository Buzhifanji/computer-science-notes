#include <stdio.h>

#define IN  1       // 在单词内
#define OUT 0       // 在单词外

int main()
{
    int c, state, worldNum, maxNum;

    int wordLength[10];
    for (int i = 0; i < 10; i++) {
        wordLength[i] = 0;
    }

    state = OUT;
    worldNum = maxNum = 0;

    while ((c = getchar()) != EOF)
    {
        if (c == ' ' || c == '\t' || c == '\n') {
            if (state == IN) {
                if (maxNum < wordLength[worldNum]) {
                    maxNum = wordLength[worldNum];
                }
                ++worldNum;
                state = OUT;
            } 
        } else if ( state == OUT) {
            state = IN;
            ++wordLength[worldNum];
        } else {
            ++wordLength[worldNum];
        }
    }

    for (int i = maxNum; i > 0; i--)
    {
        printf("%4d", i);
        for (int j = 0; j < worldNum; j++)
        {
            if(wordLength[j] >= i) {
                if (j == 0) {
                    printf("  * ");
                } else {
                    printf(" * ");
                }
            } else {
                if (j == 0) {
                    printf("    ");
                } else {
                    printf("   ");
                }
            }
        }
        printf("\n");
    }

    printf(" ");
    for (int i = 0; i <= worldNum; i++) {
        printf("%3d", i);
    }

    getchar();
}