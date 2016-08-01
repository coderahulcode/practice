#include<stdio.h>
#include<conio.h>
void main()
{
char st[100];
char *s;
clrscr();
printf("Enter string as array of character=");
gets(st);
printf("Enter string as pointer=");
gets(s);
printf("Strinf of array=%s\n",st);
printf("String of pointer=%s\n",s);
printf("String of pointer to cut first three character=%s\n",s+3);
getch();
}