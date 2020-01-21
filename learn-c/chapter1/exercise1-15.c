#include <stdio.h>

float temperature(int n);

int main() {
    int i;

    for (i = 0; i < 300; i = i + 20) 
        printf("%d %4.2f\n", i, temperature(i));
    return 0;
}

float temperature(int n) {
    float celsius;
    celsius = (5.0 / 9.0) * (n - 32.0);
    return celsius;
}