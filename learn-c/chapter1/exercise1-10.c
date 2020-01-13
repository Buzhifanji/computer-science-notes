#include <stdio.h>

int main()
{
    int c;
    while ((c = getchar()) != EOF) {
        if(c == '\t') {
            printf("\\t");
            // putchar('\\t');
        } else if (c == '\b') {
            printf("\\b");
            // putchar('\\b');
        } else if (c == '\\') {
            printf("\\");
        } else {
            putchar(c);
        }
    }
}