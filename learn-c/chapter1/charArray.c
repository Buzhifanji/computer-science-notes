#include <stdio.h>
#define MAXLINE 1000    /* maximun input line length */

int getLine(char line[], int maxline);
void copy(char to[], char from[]);

/* print the longest input line */
int main() {
    int len;                /* current line length */
    int max;                /* maximun length seen so far */
    char line[MAXLINE];     /* current input line */
    char longest[MAXLINE];  /*longest line saved here */

    max = 0;
    while ((len = getLine(line, MAXLINE)) > 0)
        if (len > max) {
            max = len;
            copy(longest, line);
        }
    if (max > 0)            /* there was a line */
        printf("%s", longest);
    return 0;
}

/* getline: read a line into s, return length */
int getLine(char s[], int lim) {    // 需要检查是否溢出，当数组满时就会停止读字符
    int c, i;

    for (i = 0; i < lim - 1 && (c = getchar()) != EOF && c != '\n'; ++i)
        s[i] = c;
    if (c == '\n') {
        s[i] = c;
        ++i;
    }
    s[i] = '\0';
    return i;
}

/* copy: copy 'from' into 'to'; assume to is big enought */
void copy(char to[], char from[]) {
    int i;
    i = 0;
    while ((to[i] = from[i] != '\0'))
        {
            printf("%c", to[i]);
            ++i;
        }
}