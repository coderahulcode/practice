#include<stdio.h>
#include<conio.h>
void add();
void mul();
void sub();
void sq();
void div();
void main()
{
int n,flag=0;
clrscr();
while(1)
{
printf("***************MENU***************\n");
printf("PRESS 1 FOR ADDITION\n");
printf("PRESS 2 FOR MULTIPLICATION\n");
printf("PRESS 3 FOR SUBTRACTION\n");
printf("PRESS 4 FOR SQUARE\n");
printf("PRESS 5 FOR DIVISION\n");
printf("PRESS 6 FOR EXIT\n");
printf("**********************************\n");
printf("enter your choice=");
scanf("%d",&n);
switch(n)
{
case 1:
add();
break;
case 2:
mul();
break;
case 3:
sub();
break;
case 4:
sq();
break;
case 5:
div();
break;
case 6:
flag=1;
break;
default:
printf("INVALID CHOICE\n");
}
if(flag==1)
break;
}
getch();
}
void add()
{
int n,a,i,sum=0;
printf("Enter the no of values=");
scanf("%d",&n);
printf("Enter the values\n");
for(i=1;i<=n;i++)
{
scanf("%d",&a);
sum=sum+a;
}
printf("Sum of %d values=%d\n",n,sum);
}
void mul()
{
int n,a,i,mul=1;
printf("Enter the no of values=");
scanf("%d",&n);
printf("Enter the values\n");
for(i=1;i<=n;i++)
{
scanf("%d",&a);
mul=mul*a;
}
printf("multiplication of %d values=%d\n",n,mul);
}
void sub()
{
int a,b,c;
printf("Enter first no=");
scanf("%d",&a);
printf("Enter second no=");
scanf("%d",&b);
c=a-b;
printf("Difference between %d and %d=%d\n",a,b,c);
}
void sq()
{
int n,s;
printf("Enter a no=");
scanf("%d",&n);
s=n*n;
printf("Square of %d=%d\n",n,s);
}
void div()
{
int a,b;
float c;
printf("Enter nenominator=");
scanf("%d",&a);
printf("Enter denominator=");
scanf("%d",&b);
c=a/b;
printf("Division of %d and %d=%f\n",a,b,c);
}
