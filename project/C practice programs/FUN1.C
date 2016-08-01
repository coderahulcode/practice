#include<stdio.h>
#include<conio.h>
void f();
void f1();
void main()
{
clrscr();
printf("MAIN\t");
f();
getch();
}
void f()
{
printf("FUNCTION 1\t");
f1();
}
void f1()
{
printf("FUNCTION 2\t");
}