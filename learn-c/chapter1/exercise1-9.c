#include <stdio.h>

/* output one space replace more space */
int main()
{
    double nc;
    int c;

    c = getchar();
    for (nc = 0; c != EOF; ++nc)
    {
        if( c == ' ') {
            c = getchar();
            if (c != ' ') {
                putchar(' ');
            }
        } else {
            putchar(c);
            c = getchar();
        }
    }
}