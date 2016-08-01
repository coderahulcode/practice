#include<stdio.h>
#include<conio.h>
void f();
int n=10;
void main()
{
int n=15;
clrscr();
printf("n=%d\n",n);
f();
//f();
//f();
//f();
//f();
getch();
}
void f()
{
//static int a=10;
printf("n=%d",n);
//printf("a=%d",a);
}