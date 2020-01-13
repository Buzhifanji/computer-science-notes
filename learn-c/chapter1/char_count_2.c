#include <stdio.h>

/* count charcters in input; 2st version */
int main()
{
    double nc;

    for (nc = 0; getchar() != EOF; ++nc)
        ;
    printf("% .0f\n", nc);
}