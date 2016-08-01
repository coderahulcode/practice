#include<stdio.h>
#include<conio.h>
void main()
{
int *a;
int b=100;
clrscr();
a=&b;
printf("value=%d\n",*a);
printf("Address=%d\n",a);
getch();
}